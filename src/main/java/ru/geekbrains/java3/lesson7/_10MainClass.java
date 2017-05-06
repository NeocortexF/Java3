package ru.geekbrains.java3.lesson7;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class _10MainClass {
    public static void main(String[] args) {
        try {
            Class someClass = Cat.class;
            Constructor catCounstructor = Cat.class.getConstructor(String.class, String.class, int.class);
            Cat cat1 = (Cat) someClass.newInstance();
            System.out.println(cat1);
            Cat cat2 = (Cat) catCounstructor.newInstance("Murzik", "Black", 3);
            System.out.println(cat2);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
