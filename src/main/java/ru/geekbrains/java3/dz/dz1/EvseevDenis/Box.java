package ru.geekbrains.java3.dz.dz1.EvseevDenis;

import java.util.ArrayList;

/**
 * box of fruits created by Денис on 11.04.2017.
 */
public class Box<F extends Fruit> {
    ArrayList<F> fruitList;

    public ArrayList<F> getFruitList() {
        return fruitList;
    }

    public Box(ArrayList<F> fruitList) {
        this.fruitList = fruitList;
    }

    public void addOne(F fruit) {
        this.fruitList.add(fruit);
    }

    public float getWeight() {
        float weight = 0.0f;
        for (F f : this.fruitList) {
            weight += f.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<?> another_box) {
        return this.getWeight() == another_box.getWeight();
    }

    public void addToanother(Box<F> another_box) {
        another_box.getFruitList().addAll(this.getFruitList());
    }

}
