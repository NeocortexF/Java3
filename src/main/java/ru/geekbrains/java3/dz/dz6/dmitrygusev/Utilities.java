package ru.geekbrains.java3.dz.dz6.dmitrygusev;

/**
 * Created by Дмитрий on 30.04.2017.
 * Домашка 6.
 */
class Utilities {

    /** Задача 1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив,
     * метод должен вернуть новый массив, который получен путем вытаскивания элементов из исходного массива,
     * идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
     * в противном случае в методе необходимо выбросить RuntimeException.
     * Написать набор тестов для этого метода (варианта 3-4 входных данных)*/
    int[] getAllAfterLast4(int[] arr) {
        int index = 0;
        int len = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                index = i;
                len = arr.length - i;
                break;
            }
        }
        if(len == 0) {
            throw new RuntimeException();
        }

        int[] result = new int[len - 1];

        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i + index + 1];
        }
        return result;
    }

    boolean hasOnly4and1(int[] arr) {
        int one = 0;
        int four = 0;
        for(int i: arr) {
            switch (i) {
                case 1:
                    one++;
                    break;
                case 4:
                    four++;
                    break;
                default:
                    return false;
            }
        }
        return !(one == 0 || four == 0);
    }
}

