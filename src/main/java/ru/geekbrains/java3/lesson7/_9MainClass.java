package ru.geekbrains.java3.lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class _9MainClass {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik");
        try {
            Method mMeow = Cat.class.getDeclaredMethod("meow", int.class);
            mMeow.invoke(cat, 5);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
