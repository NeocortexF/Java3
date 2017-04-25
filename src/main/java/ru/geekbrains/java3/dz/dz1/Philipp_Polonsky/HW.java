package ru.geekbrains.java3.dz.dz1.Philipp_Polonsky;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author  ph.polonsky@gmail.com
 * @version 1.0 13.04.17
 */
public class HW<T> {
    public T[] array;

    public static void main(String[] args) {
        // HM task 1
        String[] arr1 = {"str1", "str2", "str3"};
        HW<String> task1 = new HW<String>(arr1);
        System.out.println(task1.toString());
        task1.change(2, 1);
        System.out.println(task1.toString());
        // HM task 2
        Float[] arr2 = {1.2f, 2.3f, 3.4f, 4.5f};
        HW<Float> task2 = new HW<Float>(arr2);
        ArrayList<Float> list = task2.toArrayList(task2.array);
        System.out.println(list.toString());
        // task 3
        Box<Apple> appleBox = new Box<Apple>();
        for (int i = 0; i < 3; i++) {
            appleBox.add(new Apple());
        }
        System.out.println(appleBox.toString());

        Box<Orange> orangeBox = new Box<Orange>();
        for (int i = 0; i < 2; i++) {
            orangeBox.add(new Orange());
        }
        System.out.println(orangeBox.toString());

        System.out.println("appleBox weight " + appleBox.getWeight());
        System.out.println("orangeBox weight " + orangeBox.getWeight());
        System.out.println("Boxes comparing: " + appleBox.compare(orangeBox));
        orangeBox.add(new Orange());
        System.out.println("orangeBox weight " + orangeBox.getWeight());
        System.out.println("Boxes comparing: " + appleBox.compare(orangeBox));

        Box<Apple> newAppleBox = new Box<Apple>();
        appleBox.toAnotherBox(newAppleBox);
        System.out.println("appleBox weight " + appleBox.getWeight());
        System.out.println("newAppleBox weight " + newAppleBox.getWeight());
        System.out.println(appleBox.toString());
        System.out.println(newAppleBox.toString());
    }

    public HW(T[] array) {
        this.array = array;
    }

    public void change(int index1, int index2) { //Task1
        if (((0 <= index1) && (index1 < array.length)) && ((0 <= index2) && (index2 < array.length))) {
            T element1 = array[index1];
            array[index1] = array[index2];
            array[index2] = element1;
        } else {
            System.out.println("Cannot change: out of range!");
        }
    }

    public ArrayList<T> toArrayList(T[] arr) { //task2
        ArrayList<T> list = new ArrayList<T>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    @Override
    public String toString() {
        return "HW{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
