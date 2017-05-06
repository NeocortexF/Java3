package ru.geekbrains.java3.lesson7;

import java.lang.reflect.Modifier;


public class _2Modifier {
    public static void main(String[] args) {
        Class strClass = String.class;
        int modifiers = strClass.getModifiers();
        if (Modifier.isPublic(modifiers)) {
            System.out.println(strClass.getSimpleName() + " - public");
        }
        if (Modifier.isAbstract(modifiers)) {
            System.out.println(strClass.getSimpleName() + " - abstract");
        }
        if (Modifier.isFinal(modifiers)) {
            System.out.println(strClass.getSimpleName() + " - final");
        }
    }
}
