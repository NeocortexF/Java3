package ru.geekbrains.java3.dz.dz1.AnosovAlexey.lesson1;

import java.util.Arrays;

public class ArrayGen<T> {
    static int arrCount = 0;
    
    private T[] arr;
    private int arrNumb;
    public final int size;
    
    public ArrayGen (T ... arr) {
        this.arr = arr;
        arrNumb  = ++arrCount;
        size = arr.length;
    }
    
    public T[] getArray() {
        return arr;
    }
    
    public void info() {
        System.out.println(arrNumb + ": " + Arrays.toString(arr));
    }
    
    public void interchange(int i, int j) {
        T buf;
        buf = arr[i];
        arr[i] = arr[j];
        arr[j] = buf;
    }
}
