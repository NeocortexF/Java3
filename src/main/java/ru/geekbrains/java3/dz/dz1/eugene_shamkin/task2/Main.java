package ru.geekbrains.java3.dz.dz1.eugene_shamkin.task2;


import java.util.Arrays;
import java.util.List;

/** Geekbrains.ru
 *  Course name: Java 3
 *  Homework 1, performed by Eugene Shamkin, April 11, 2017
 *  **********************************************************
 *  Написать метод, который преобразует массив в ArrayList;
 */
public class Main {

       public static void main(String[] args) {
           int[] arr={1,2,3,4,5,6,7,8,9};
           List<?> list= Arrays.asList(arr);
           System.out.println(list);
       }
}


