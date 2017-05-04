package ru.geekbrains.java3.dz.dz6.eugene_shamkin;

import java.util.stream.IntStream;

/**
 * Написать метод, который проверяет что массив состоит только из чисел 1 и 4.
 * Если в массиве нет хоть одной 4 или 1, то метод вернет false;
 * Написать набор тестов для этого метода (варианта 3-4 входных данных)
 */
public class Task2 {

    public boolean isArrayContainsOnly4and1(int[] array) {
        boolean containsFour = IntStream.of(array).anyMatch(x -> x == 4);
        boolean containsOne = IntStream.of(array).anyMatch(x -> x == 1);
        if (containsFour == true || containsOne == true) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        Task2 task2 = new Task2();
        int[] testArray = new int[] {9,0,78,7,9,54,32,6,47,1,8};
        System.out.println(task2.isArrayContainsOnly4and1(testArray));
    }
}
