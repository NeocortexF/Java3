package ru.geekbrains.java3.dz.dz1.eugene_shamkin.Task1;

import java.util.Scanner;

/** Geekbrains.ru
 *  Course name: Java 3
 *  Homework 1, performed by Eugene Shamkin, April 11, 2017
 *  **********************************************************
 *  Написать метод, который меняет два элемента
 *  массива местами.(массив может быть любого ссылочного типа);
 */
public class Main {
    private int size;

    public static void main(String[] args) {
        Main m = new Main();
        ArrayHolder filledArray = m.arrayInitializator();
        filledArray.info();
        filledArray.intermixElements();
        filledArray.info();

    }

    private ArrayHolder arrayInitializator() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер массива: \n");
        size = input.nextInt();
        Integer array[] = new Integer[size];
        System.out.println("Введите последовательно числа в массив: \n");
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }
        ArrayHolder<Integer> myArray = new ArrayHolder<Integer>(array);
        return myArray;
    }


}
