package ru.geekbrains.java3.lesson3;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String phone;
    private transient String password;

    private Zachetka z;

    public Zachetka getZ() {
        return z;
    }

    public Student(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.z = new Zachetka("123");
        System.out.println("Constructor");
    }

    public void info() {
        System.out.println(name + " " + phone + " " + z.getId());
    }
}
