package ru.geekbrains.java3.dz.dz1.Philipp_Polonsky;

import java.util.ArrayList;

/**
 * Created by sbt-polonskiy-fv on 13.04.17.
 */
public class Box<T extends Fruit> {
    ArrayList<T> fruits;

    public Box(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    public Box() {
        this.fruits = new ArrayList<T>();
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        if (fruits.size() == 0) {
            return 0f;
        } else {
            return fruits.size() * fruits.get(0).weight;
        }
    }

    public boolean compare(Box box) {
        return (this.getWeight() == box.getWeight());
    }

    public void toAnotherBox(Box<T> box) {
        for (T fruit: fruits) {
            box.add(fruit);
        }
        fruits.clear();
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruits=" + fruits +
                '}';
    }
}
