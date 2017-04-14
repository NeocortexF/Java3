package ru.geekbrains.java3.dz.dz1.shurukhin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Класс коробки
 */
class BoxOfFruits<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<>();

    BoxOfFruits(int amount, T fruit) {
        for (int i = 0; i < amount; i++) {
            fruits.add(fruit);
        }
    }

    //Добавляем 1 и более фруктов как массив
    void addFruit(T... fruit) {
        if (fruit.length > 0)
            fruits.addAll(Arrays.asList(fruit));
    }

    //Добавляем 1 и более фруктов через указание кол-ва
    void addFruit(int amount, T fruit) {
        if (amount > 0)
            for (int i = 0; i < amount; i++) {
                fruits.add(fruit);
            }
    }

    //Добавляем фрукты из другого ящика
    void addFruit(ArrayList<T> fruit) {
        if (fruit.size() > 0)
            fruits.addAll(fruit);
    }

    //Достаем один фрукт из коробки
    T getOne() {
        T fruit = fruits.get(fruits.size() - 1);
        fruits.remove(fruits.size() - 1);
        return fruit;
    }

    //Достаем какое-то заданное кол-во яблок
    ArrayList<T> getSeveral(int amount) {
        if (amount > 0) {
            ArrayList<T> part = new ArrayList<>();
            part.addAll(fruits.subList(fruits.size() - amount, fruits.size() - 1));
            for (int i = 1; i <= amount; i++)
                fruits.remove(fruits.size() - i);
            return part;
        }
        return new ArrayList<>();
    }

    //Высыпаем все фрукты из текущего ящика
    ArrayList<T> getAll() {
        ArrayList<T> fruits = this.fruits;
        this.fruits = new ArrayList<>();
        return fruits;
    }

    //Пересыпаем фрукты из текущего ящика в другой
    void moveTo(BoxOfFruits<T> box) {
        box.addFruit(getAll());
    }

    //Получение веса ящика
    float getWeight() {
        if (fruits.size() == 0) return 0f;
        return fruits.size() * fruits.get(0).getWeight();
    }

    //Сравнение веса текущего ящика с другим ящиком
    boolean compareTo(BoxOfFruits<? extends Fruit> box) {
        return getWeight() == box.getWeight();
    }
}
