package org.otus.hw09.table;

import org.otus.hw09.ID;

public class User {
    @ID
    private long id;
    private String name;
    private int age;

    public User(String name, int age){
        this.name = name;
        this.age = age;
    }

    public User(long id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Class: " + getClass().getName() + " - {id: " + this.id + ", name: " + this.name + ", age: " + this.age + "}";
    }
}
