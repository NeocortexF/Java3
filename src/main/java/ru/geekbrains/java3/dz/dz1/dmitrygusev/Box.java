package ru.geekbrains.java3.dz.dz1.dmitrygusev;

import ru.geekbrains.java3.dz.dz1.dmitrygusev.exceptions.MixFruitError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Дмитрий on 11.04.2017.
 * Класс-дженерик
 */
class Box<T extends Fruit> {
    private List<T> list;

    Box(T... obj) {
        list = Arrays.asList(obj);
    }
    Box() {
        list = new ArrayList<T>();
    }

    void add(T obj) {
            list.add(obj);
    }

    void moveAt(Box<T> box) {
        for (T obj : list) {
            box.add(obj);
        }
        list.clear();
    }

    void info() {
        System.out.println("В коробке находятся " + list.get(0).toString() + " в количестве: " + list.size());
    }

    float getWeight() {
        return list.size() * list.get(0).getWeight();
    }

    boolean compare(Box<? extends Fruit> box) {
        return this.getWeight() == box.getWeight();
    }


}
