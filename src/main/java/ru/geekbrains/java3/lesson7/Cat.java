package ru.geekbrains.java3.lesson7;

public class Cat {
    public String name;
    public String color;
    public int age;

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat(String name) {
        this.name = name;
    }

    public Cat() {
    }

    public void meow(int dB) {
        System.out.println(name + ": meow - " + dB + " dB");
    }

    public void jump() {
        System.out.println(name + ": jump - ");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }
}

