package ru.geekbrains.java3.dz.dz1.eugene_shamkin.task2;


import java.util.ArrayList;

/**
 * Geekbrains.ru
 * Course name: Java 3
 * Homework 1, performed by Eugene Shamkin, April 11, 2017
 * **********************************************************
 * Написать метод, который преобразует массив в ArrayList;
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        String array[] = {"Строка 1", "Строка 2", "Строка 3", "Строка 4"};
        for (int i = 0; i < array.length; i++) {
            arrayList.add(array[i]);
        }
        for (String str : arrayList) {
            System.out.println(str);
        }
    }
}


