package org.otus.hw09;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JdbcTemplateImpl implements JdbcTemplate {
    private Connection connection;

    public JdbcTemplateImpl(String url, String user) throws SQLException, ClassNotFoundException {
        this(url, user, null);
    }

    public JdbcTemplateImpl(String url, String user, String password) throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        this.connection = DriverManager.getConnection(url, user, password);
        this.connection.setAutoCommit(false);
    }

    @Override
    public <T> void create(T objectData) throws SQLException {
        String name = objectData.getClass().getSimpleName();
        String columns = getColumnsObject(objectData);
        String sql = "INSERT INTO " + name + " (" + columns + ")" + " values(?)";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            Savepoint savepoint = this.connection.setSavepoint(name + objectData.hashCode());
            statement.setString(1, getValuesObject(objectData));
            try {
                int rowCount = statement.executeUpdate();
                this.connection.commit();
                System.out.println(" Insert RowCount: " + rowCount);
            } catch (SQLException e) {
                this.connection.rollback(savepoint);
                System.err.println(e.toString());
            }
        } catch (IllegalAccessException e) {
            System.err.println(e.toString());
        }
    }

    private <T> String getColumnsObject(T objectData) {
        Stream<Field> stream = Arrays.stream(objectData.getClass().getDeclaredFields());
        return stream.filter(p -> !p.isAnnotationPresent(ID.class)).map(Field::getName).collect(Collectors.joining(","));
    }

    private <T> String getValuesObject(T objectData) throws IllegalAccessException {
        Stream<Field> stream = Arrays.stream(objectData.getClass().getDeclaredFields());
        Field[] fields = stream.filter(p -> !p.isAnnotationPresent(ID.class)).toArray(Field[]::new);
        List<String> list = new ArrayList<>();
        for (Field field : fields) {
            field.setAccessible(true);
            list.add(wrapper(field, objectData));
        }
        return String.join(",", list);
    }

    private String wrapper(Field field, Object objectData) throws IllegalAccessException {
        String value = field.get(objectData).toString();
        if (field.getType() == String.class) {
            return "'" + value + "'";
        }
        return value;
    }

    @Override
    public <T> void update(T objectData) throws SQLException {
        String name = objectData.getClass().getName();
        try (PreparedStatement statement = this.connection.prepareStatement("UPDATE ? Set ? where ?")) {
            Savepoint savepoint = this.connection.setSavepoint(name + objectData.hashCode());
            statement.setString(1, name);
            statement.setString(2, getLineSet(objectData));
            statement.setString(3, getWhere(objectData));
            try {
                int rowCount = statement.executeUpdate();
                this.connection.commit();
                System.out.println(" Update RowCount: " + rowCount);
            } catch (SQLException e) {
                this.connection.rollback(savepoint);
                System.err.println(e.toString());
            }
        } catch (IllegalAccessException e) {
            System.err.println(e.toString());
        }
    }

    private <T> String getLineSet(T objectData) throws IllegalAccessException {
        Stream<Field> stream = Arrays.stream(objectData.getClass().getDeclaredFields());
        Field[] fields = stream.filter(p -> !p.isAnnotationPresent(ID.class)).toArray(Field[]::new);
        List<String> list = new ArrayList<>();
        for (Field field : fields) {
            field.setAccessible(true);
            list.add(field.getName() + "=" + wrapper(field, objectData));
        }
        return String.join(",", list);
    }

    private <T> String getWhere(T objectData) throws IllegalAccessException {
        Stream<Field> stream = Arrays.stream(objectData.getClass().getDeclaredFields());
        Field[] fields = stream.filter(p -> p.isAnnotationPresent(ID.class)).toArray(Field[]::new);
        List<String> list = new ArrayList<>();
        for (Field field : fields) {
            field.setAccessible(true);
            list.add(field.getName() + "=" + wrapper(field, objectData));
        }
        return String.join(",", list);
    }

    @Override
    public <T> void createOrUpdate(T objectData) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T load(long id, Class<T> clazz) throws SQLException {
//        try (PreparedStatement statement = this.connection.prepareStatement("")) {
//
//        }
//
//        return null;
        throw new UnsupportedOperationException();
    }

    @Override
    public void close() throws IOException {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                throw new IOException(e);
            }
        }
    }
}
