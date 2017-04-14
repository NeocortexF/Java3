package ru.geekbrains.java3.dz.dz1.EvseevDenis;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  домашка 1 Created by Денис on 11.04.2017.
 */
public class Main {

    static <T> void swap(T[] arrr,int e1,int e2){
        T temp = arrr[e1];
        arrr[e1] = arrr[e2];
        arrr[e2] = temp;
    }

    static <T> ArrayList<?> toArrayLLL (T[] ar){
        return new ArrayList<T>(Arrays.asList(ar));
    }

    public static ArrayList<Apple> makeMoreApples (int n){
        ArrayList<Apple> fruits = new ArrayList<Apple>();
        for (int i = 0; i <n ; i++) {
            fruits.add(new Apple());
        }
        return fruits;
    }
    public static ArrayList<Orange> makeMoreOranges (int n){
        ArrayList<Orange> fruits = new ArrayList<Orange>();
        for (int i = 0; i <n ; i++) {
            fruits.add(new Orange());
        }
        return fruits;
    }

    public static void main(String[] args) {
        Integer[]ints = {1,2,3,4,5,6};
        String[] strings = {"s","a","d"};
        Object[] objects = {new Object(),new Object()};

        swap(ints,1,2);
        System.out.println(toArrayLLL(ints));
        System.out.println();
        swap(strings,0,1);
        System.out.println(toArrayLLL(strings));

        System.out.println();

        System.out.println(objects);

        System.out.println("big tasK");

        Box <Apple> boxOfApples = new Box(makeMoreApples(5));
        Box <Apple> boxOfApples7 = new Box(makeMoreApples(7));
        Box <Orange> boxOfOganges = new Box(makeMoreOranges(7));
        Box <Orange> boxOfOganges7 = new Box(makeMoreOranges(4));
        boxOfApples.addOne(new Apple());
        System.out.println(boxOfApples.getWeight());
        boxOfApples7.addOne(new Apple());
        boxOfApples7.addOne(new Apple());
        System.out.println(boxOfApples7.getWeight());

        System.out.println(boxOfApples7.compare(boxOfOganges));
        System.out.println(boxOfOganges7.compare(boxOfApples));
        System.out.println("пресыпим и взвесим");
        boxOfApples.addToanother(boxOfApples7);
//        boxOfApples7.addToanother(boxOfOganges); //не работает как и ожидалось
        System.out.println(boxOfApples7.getWeight());
        System.out.println(boxOfOganges.getWeight());

    }
}
