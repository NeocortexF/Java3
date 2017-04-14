package ru.geekbrains.java3.dz.dz1.shurukhin;

import java.util.Map;
import java.util.HashMap;

/**
 * Класс фрукта
 */
abstract class Fruit {
    private static Map<Class, Float> weights = new HashMap<>();     //Мапа для хранения весов фруктов. Незачем делать поле на классе каждого фрукта

    Fruit(float weight) {
        weights.put(getClass(), weight);
    }

    float getWeight() {
        return weights.get(getClass());
    }
}
