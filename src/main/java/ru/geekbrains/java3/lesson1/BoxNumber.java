package ru.geekbrains.java3.lesson1;

import java.io.Serializable;

/**
 * Created by Home-pc on 10.04.2017.
 */
public class BoxNumber<T extends Number & Serializable & Comparable> {
    private T obj;

    public T getObj() {
//        return new T();  так не работает
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public BoxNumber(T obj) {
        this.obj = obj;
    }

    public void info() {
        System.out.println("obj: " + obj);
        System.out.println("type: " + obj.getClass());
    }
}