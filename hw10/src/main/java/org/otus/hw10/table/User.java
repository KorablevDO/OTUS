package org.otus.hw10.table;

import java.util.List;

public class User {
    private long id;
    private String name;
    private int age;
    private AddressDataSet addressDataSet;
    private List<PhoneDataSet> phoneDataSetList;

    public User(String name, int age, AddressDataSet addressDataSet, List<PhoneDataSet> phoneDataSetList){
        this.name = name;
        this.age = age;
        this.addressDataSet = addressDataSet;
        this.phoneDataSetList =phoneDataSetList;
    }

    public User(long id, String name, int age, AddressDataSet addressDataSet, List<PhoneDataSet> phoneDataSetList){
        this.id = id;
        this.name = name;
        this.age = age;
        this.addressDataSet = addressDataSet;
        this.phoneDataSetList =phoneDataSetList;
    }

    public void setId(long id){
        this.id = id;
    }

    public void  setName(String name){

    }

    @Override
    public String toString() {
        return "Class: " + getClass().getName() + " - {id: " + this.id + ", name: " + this.name + ", age: " + this.age + "}";
    }
}
