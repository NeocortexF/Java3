package ru.geekbrains.java3.dz.dz1.dmitrygusev;

/**
 * Created by Дмитрий on 11.04.2017.
 * абстрактный класс фруктов. ибо нефиг создавать экземпляры неизвестного фрукта
 */
abstract class Fruit {
    private float weight;

    Fruit(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }
}
