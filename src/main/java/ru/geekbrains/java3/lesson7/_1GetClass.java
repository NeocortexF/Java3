package ru.geekbrains.java3.lesson7;


public class _1GetClass {
    public static void main(String[] args) throws ClassNotFoundException {
        String s = "retsrter";
        Class sClass = s.getClass();
        Class sClass2 = String.class;
        Class sClass3 = Class.forName("java.lang.String");
        System.out.println(sClass.getName());
        System.out.println(sClass2.getSuperclass());
        System.out.println(sClass3.getSimpleName());

    }
}

