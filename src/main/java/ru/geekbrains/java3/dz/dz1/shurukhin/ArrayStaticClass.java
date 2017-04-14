package ru.geekbrains.java3.dz.dz1.shurukhin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class ArrayStaticClass {
    /**
     * 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа)
     */
    static <T> void swapArrElements(T[] arr, int first, int second) {
        T tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;
    }
    /**
     * 2. Написать метод, который преобразует массив в ArrayList
     */
    static <T> ArrayList<T> convertArrToList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));     //Просто возвращаем объект ArrayList, заполненный элементами массива
    }
}
