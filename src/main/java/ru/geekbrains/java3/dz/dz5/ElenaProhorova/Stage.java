package ru.geekbrains.java3.dz.dz5.ElenaProhorova;

import java.util.concurrent.Semaphore;

public abstract class Stage {
    protected int length;
    protected String description;
    protected Semaphore smp;

    public String getDescription() {
        return description;
    }

    public abstract void go(Car c);
}
