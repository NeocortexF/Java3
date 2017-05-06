package ru.geekbrains.java3.lesson7.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClass {
    @MarkingAnnotation
    public void markedMethod() {
        System.out.println("Java");
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = MyClass.class.getDeclaredMethods();
        for (Method o : methods) {
            if (o.getAnnotation(MarkingAnnotation.class) != null) {
                System.out.println(o);
                MyClass myClass = new MyClass();
                o.invoke(myClass);
            }
        }
    }
}
