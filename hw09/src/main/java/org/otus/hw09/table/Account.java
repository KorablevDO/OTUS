package org.otus.hw09.table;

import org.otus.hw09.ID;

public class Account {
    private long no;
    private String type;
    private int rest;

    public Account(String type, int rest){
        this.type = type;
        this.rest = rest;
    }

    public Account(long no, String type, int rest){
        this.no = no;
        this.type = type;
        this.rest = rest;
    }

    @Override
    public String toString() {
        return "Class: " + getClass().getName() + " - {no: " + this.no + ", type: " + this.type + ", rest: " + this.rest + "}";
    }
}
