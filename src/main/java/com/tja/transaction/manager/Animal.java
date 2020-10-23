package com.tja.transaction.manager;

import com.opencsv.bean.CsvBindByName;

public class Animal {
    @CsvBindByName(required = false, column = "reign")
    private String bla;
    @CsvBindByName
    private String name;
    @CsvBindByName(required = false)
    private int age;

    public String getBla() {
        return bla;
    }

    public void setBla(String bla) {
        this.bla = bla;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "reign='" + bla + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
