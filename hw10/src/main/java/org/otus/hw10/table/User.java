package org.otus.hw10.table;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private int age;

    @OneToOne(mappedBy = "user_id", cascade = CascadeType.ALL)
    private AddressDataSet addressDataSet;

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL, orphanRemoval = true)
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

    public void  setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setAddressDataSet(AddressDataSet addressDataSet){
        this.addressDataSet = addressDataSet;
    }

    public void setPhoneDataSetList(){

    }

    @Override
    public String toString() {
        return "Class: " + getClass().getName() + " - {id: " + this.id + ", name: " + this.name + ", age: " + this.age + "}";
    }
}
