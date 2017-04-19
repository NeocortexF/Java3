package ru.geekbrains.java3.dz.dz2.GoryainovVladimir;

import java.util.Arrays;

/**
 * Created by Vladimir on 16.04.2017.
 */
public class ProductsGen<T> {
    private T[] arr;

    public ProductsGen(T ... arr) {
        this.arr = arr;
    }

    public T[] getArr() {
        return arr;
    }

    public void printInfo() {
        System.out.println(Arrays.toString(arr));
    }
}
