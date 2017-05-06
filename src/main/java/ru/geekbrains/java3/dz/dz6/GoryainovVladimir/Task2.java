package ru.geekbrains.java3.dz.dz6.GoryainovVladimir;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladimir on 03.05.2017.
 */
public class Task2 {
    static boolean checkArray(int[] mas) {
        List<Integer> arr = new ArrayList<>();
        for (int x : mas) {
            arr.add(x);
            if (x != 1 && x != 4) return false;
        }

        if (arr.contains(1) && arr.contains(4)) return true;

        return false;
    }
}
