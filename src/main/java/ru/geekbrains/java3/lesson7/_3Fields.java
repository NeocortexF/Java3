package ru.geekbrains.java3.lesson7;

import java.lang.reflect.Field;

public class _3Fields {
    public static void main(String[] args) {
        Class catClass = Cat.class;
        Field[] publicFields = catClass.getFields();
        for (Field o : publicFields) {
            System.out.println("Тип_поля Имя_поля : " + o.getType().getName() + " " + o.getName());
        }
    }
}
