package ru.geekbrains.java3.dz.dz1.TintulAnton;

import java.util.ArrayList;

/**
 * Created by 1 on 12.04.2017.
 */
public class MainClass {

    public static void main(String[] args) {

        //Task 1
        TasksWithArray<String> tasksWithArray = new TasksWithArray<String>();
        tasksWithArray.setArray("123", "234", "345", "456");
        tasksWithArray.changeTwoElements(0, 3);
        tasksWithArray.printArray();

        //Task 2
        TasksWithArray<Integer> tasksWithArray2 = new TasksWithArray<Integer>();
        tasksWithArray2.setArray(1, 2, 3, 4, 5);
        ArrayList<Integer> arrayList = tasksWithArray2.arrayToArrayList();
        tasksWithArray2.printArrayList(arrayList);

        //Task 3
        Box<Apple> box1 = new Box<Apple>();
        Box<Orange> box2 = new Box<Orange>();

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        box1.setWeightOfFruit(apple1.getWeightOfApple());
        box1.fillTheBox(apple1, apple2, apple3);

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        box2.setWeightOfFruit(orange1.getWeightOfOrange());
        box2.fillTheBox(orange1, orange2, orange3);

        System.out.println(box1.compare(box2));

        Box<Apple> boxOfApples = new Box<Apple>();

        box1.changeTheBox(boxOfApples);
        boxOfApples.printArrayList();

    }

}
