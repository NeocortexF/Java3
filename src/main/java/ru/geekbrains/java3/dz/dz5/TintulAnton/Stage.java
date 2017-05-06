package ru.geekbrains.java3.dz.dz5.TintulAnton;

public abstract class Stage {
    protected int length;
    protected String description;

    public String getDescription() {
        return description;
    }

    public abstract void go(Car c);
}
