package ru.geekbrains.java3.lesson7;

import java.lang.reflect.Constructor;

public class _7MainClass {
    public static void main(String[] args) {
        Constructor[] constructors = Cat.class.getConstructors();
        for (Constructor o : constructors) {
            System.out.println(o);
        }
        System.out.println("---");
        try {
            System.out.println(Cat.class.getConstructor(new Class[]{String.class, int.class}));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
