package ru.geekbrains.java3.dz.dz1.eugene_shamkin.Task1;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayHolder<T extends Object> {
    private T[] myArray;
    private int lowElement;
    private int highElement;

    public ArrayHolder(T... myArray) {
        this.myArray = myArray;
    }

    public T[] getMyArray() {
        return myArray;
    }

    public void setMyArray(T[] myArray) {
        this.myArray = myArray;
    }

    public void info() {
        System.out.println(Arrays.toString(myArray));
    }

    public void intermixElements() {
        Scanner input = new Scanner(System.in);
        System.out.println("Выберите два элемента для того, что бы поменять их местами: \n");
        lowElement = input.nextInt();
        if (lowElement < myArray.length || lowElement > myArray.length) {
            System.out.println("Выберите значение первого элемента в диапазоне от 0 до " + myArray.length);
        }
        highElement = input.nextInt();
        if (highElement < myArray.length || highElement > myArray.length) {
            System.out.println("Выберите значение второго элемента в диапазоне от 0 до " + myArray.length);
        }
        T tempElement = myArray[lowElement];
        myArray[lowElement] = myArray[highElement];
        myArray[highElement] = tempElement;
    }

}
