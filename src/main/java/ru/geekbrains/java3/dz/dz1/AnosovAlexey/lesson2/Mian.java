package ru.geekbrains.java3.dz.dz1.AnosovAlexey.lesson2;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;

public class Mian {

    public static <T> ArrayList arrayToList(ArrayList arrayList, T[] arr) {
        for (T i: arr) arrayList.add(i);
        return arrayList;
    }   
    
    public static void main(String[] args) {
        Integer[] intArray = new Integer[]{123, 323, 23424, 23424, 2342, 242, 456, 534};
        System.out.println("array: " + Arrays.toString(intArray));
        
        ArrayList arrayList = arrayToList(new ArrayList(), intArray);
        System.out.print("arrayList: " + arrayList);
    }
    
}
