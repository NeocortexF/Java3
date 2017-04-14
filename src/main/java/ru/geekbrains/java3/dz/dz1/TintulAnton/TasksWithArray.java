package ru.geekbrains.java3.dz.dz1.TintulAnton;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by 1 on 12.04.2017.
 */
public class TasksWithArray <E> {

    private E[] array;

    public void setArray(E... array) {
        this.array = array;
    }

    public E[] changeTwoElements(int firstIndex, int secondIndex){
        E stmnt;

        stmnt = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = stmnt;

        return array;
    }

    public void printArray(){
        System.out.println(Arrays.toString(array));
    }

    public ArrayList<E> arrayToArrayList(){
        ArrayList<E> arrayList = new ArrayList<E>();

        for (int i = 0; i < array.length; i++) arrayList.add(array[i]);

        return arrayList;
    }

    public void printArrayList(ArrayList<E> arrayList){
        for (int i = 0; i < arrayList.size(); i++) System.out.println((i + 1) + ". " + arrayList.get(i));

    }

}
