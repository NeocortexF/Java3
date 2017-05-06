package ru.geekbrains.java3.lesson7;

public class ClassWithPrivateField {
    private int field;

    public ClassWithPrivateField(int field) {
        this.field = field;
    }

    public void info() {
        System.out.println("field: " + field);
    }
}
