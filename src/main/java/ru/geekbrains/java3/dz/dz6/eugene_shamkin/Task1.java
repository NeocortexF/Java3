package ru.geekbrains.java3.dz.dz6.eugene_shamkin;

import java.util.Arrays;

/**
 * Написать метод, которому в качестве аргумента передается не пустой одномерный
 * целочисленный массив, метод должен вернуть новый массив, который получен путем
 * вытаскивания элементов из исходного массива, идущих после последней четверки.
 * Входной массив должен содержать хотя бы одну четверку, в противном случае в методе
 * необходимо выбросить RuntimeException. Написать набор тестов для этого метода
 * (варианта 3-4 входных данных) вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ]
 */
public class Task1 {

    public int[] getArray(int[] array) {
        int lastNumberFour = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) { lastNumberFour = i; }
        }
        if (lastNumberFour == 0) {
            throw new RuntimeException("Массив не содержит ни одной четверки!");
        } else {
            lastNumberFour++;
            int[] newArray = new int[array.length - lastNumberFour];
            System.arraycopy(array, lastNumberFour, newArray, 0, array.length - lastNumberFour);
            return newArray;
        }
    }

    public static void main(String[] args) {
        Task1 task = new Task1();
        int[] testIntArray =  {1, 4, 3, 3, 5, 6};
        System.out.println(Arrays.toString(task.getArray(testIntArray)));
    }
}
