package ru.geekbrains.java3.dz.dz5.shurukhin;

abstract class Stage {
    protected int length;
    String description;

    String getDescription() {
        return description;
    }

    abstract void go(Car c);
}
