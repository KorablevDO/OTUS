package org.otus.hw09;

import org.otus.hw09.table.Account;
import org.otus.hw09.table.User;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {
    private static String url = "jdbc:h2:./path/to/database/OTUS/HW09";
    private static String user = "root";

    public static void main(String[] args) throws SQLException, IOException, IllegalAccessException, ClassNotFoundException {
                try (JdbcTemplate template = new JdbcTemplateImpl(url, user)) {
            template.create(new User("Nikita", 23));
//            User user1 = template.load(0, User.class);
//            System.out.println(user1);
//            template.update(new User("Nikita", 25));
//            User user2 = template.load(0, User.class);
//            System.out.println(user2);
//            template.createOrUpdate(new User("Denis", 33));
//            template.createOrUpdate(new User("Denis", 43));

//        template.create(new Account("9987", 55));
//        Account account1 = template.load(0, Account.class);
//        System.out.println(account1);
//        template.update(new Account("9987", 55));
//        Account account2 = template.load(0, Account.class);
//        System.out.println(account2);
//        template.createOrUpdate(new Account("5587", 20));
//        template.createOrUpdate(new Account("2287", 2));
        }
    }

}
