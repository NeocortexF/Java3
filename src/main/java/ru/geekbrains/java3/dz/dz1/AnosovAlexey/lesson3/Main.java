package ru.geekbrains.java3.dz.dz1.AnosovAlexey.lesson3;

public class Main {

    public static void main(String[] args) {
        Box<Orange> orangeBox = new Box<>();
        for (int i = 0; i < 10; i++) orangeBox.add(new Orange()); // положили 10 апельсинов
        orangeBox.info();
        
        Box<Apple> appleBox1 = new Box<>();
        for (int i = 0; i < 10; i++) appleBox1.add(new Apple()); // положили 10 яблок
        appleBox1.info();
        
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());
        System.out.println("Вес коробки с яблоками: " + appleBox1.getWeight());
        if (!orangeBox.compare(appleBox1)) System.out.println("Вес коробок разный");
        
        Box<Apple> appleBox2 = new Box<>();
        for (int i = 0; i < 5; i++) appleBox2.add(new Apple()); // положили 5 яблок
        appleBox2.info();
        System.out.println("Пересыпали в коробку 2");
        appleBox1.addBox(appleBox2);                            // пересыпали из одной коробки в другую
        
        System.out.println("Вес коробки с яблоками: " + appleBox1.getWeight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());
        if (appleBox1.compare(orangeBox)) System.out.println("Вес коробок одинаковый");
        appleBox1.info();

    }
    
}
