package ru.geekbrains.java3.dz.dz6.GoryainovVladimir;

import java.util.ArrayList;

/**
 * Created by Vladimir on 03.05.2017.
 */
public class Task1 {

    static int[] newArray(int[] arr) throws RuntimeException {
        int element = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int x : arr) {
            list.add(x);
        }

        if (!list.contains(4)) throw new RuntimeException("В массиве нет элемента со значением 4.");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                element = ++i;
            }
        }

        int[] mas = new int[arr.length - element];
        System.arraycopy(arr, element, mas, 0, arr.length - element);

        return mas;
    }
}
