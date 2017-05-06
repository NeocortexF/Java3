package ru.geekbrains.java3.lesson7;

import java.lang.reflect.Field;

public class _5MainClass {
    public static void main(String[] args) {
        try {
            Cat cat = new Cat();
            Field fieldName = cat.getClass().getField("name");
            fieldName.set(cat, "Murzik");
            Field fieldAge = cat.getClass().getField("age");
            System.out.println(fieldAge.get(cat));
            System.out.println(cat);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
