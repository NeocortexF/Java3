package ru.geekbrains.java3.lesson7.annotation.advanced;

import java.lang.reflect.Method;

public class MainClass {
//    @AdvancedAnnotation(value = 20.0f)
    @AdvancedAnnotation
    public void advAnnotatedMethod() {
        System.out.println("...");
    }

    public static void main(String[] args) {
        try {
            Method m = MainClass.class.getMethod("advAnnotatedMethod", null);
            AdvancedAnnotation annotation = m.getAnnotation(AdvancedAnnotation.class);
            System.out.println("value: " + annotation.value());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
