package org.otus.hw09;

import java.io.Closeable;
import java.sql.SQLException;

public interface JdbcTemplate extends Closeable {
    public <T> void create(T objectData) throws SQLException;

    public <T> void update(T objectData) throws SQLException;

    public <T> void createOrUpdate(T objectData);

    public <T> T load(long id, Class<T> clazz) throws SQLException;
}
