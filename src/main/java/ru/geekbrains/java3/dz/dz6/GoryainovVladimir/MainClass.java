package ru.geekbrains.java3.dz.dz6.GoryainovVladimir;

import java.util.Arrays;

/* Task1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив,
 * метод должен вернуть новый массив, который получен путем вытаскивания элементов из исходного массива,
 * идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, в противном случае
 * в методе необходимо выбросить RintimeException.
 * Написать набор тестов для этого метода (варианта 3-4 входных данных)
 * вх: [ 1 2 4 4 2 3 4 1 7 ] -> [ 1 7 ].
 * Task2. Написать метод, который проверяет, что массив состоит только из чисел 1 и 4.
 * Если в массиве неть хоть одной 4 или 1, то метод вернет false.
 * Написать набор тестов для этого метода (варианта 3-4 входных данных).
 * Task3 (не сделано). Создать небольшую БД (таблица: студенты; поля: id, фамилия, балл). Написать тесты для
 * проверки того, что при работе с базой корректно добавляются, обновляются и читаются записи.
 * Следует учесть, что в базе есть заранее добавленные записи, и после проведения тестов эти записи
 * не должны быть удалены/изменены/добавлены.*/
public class MainClass {

    public static void main(String[] args) {
        final int[] mas1 = { 1, 2, 4, 4, 5, 4, 2, 1, 7 };
        final int[] mas2= {1, 4, 1, 4, 1};

        System.out.println("Task 1: ");
        System.out.println(Arrays.toString(Task1.newArray(mas1)));

        System.out.println();

        System.out.println("Task 2: ");
        System.out.println(Task2.checkArray(mas2));
    }
}