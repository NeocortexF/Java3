package ru.geekbrains.java3.lesson1;

/**
 * Created by Home-pc on 10.04.2017.
 */
public class BoxInt {
    private Integer obj;

    public Integer getObj() {
        return obj;
    }

    public void setObj(Integer obj) {
        this.obj = obj;
    }

    public BoxInt(Integer obj) {
        this.obj = obj;
    }

    public void info() {
        System.out.println("obj: " + obj);
        System.out.println("type: " + obj.getClass());
    }
}
