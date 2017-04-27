package ru.geekbrains.java3.dz.dz4.shurukhin;

import com.google.common.collect.Iterables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * 1. Создать три потока, каждый из которых выводит определенную букву(A, B и C) 5 раз, порядок
 * должен быть именно ABСABСABС. Используйте wait/notify/notifyAll.
 */
class PrintLetter {
    private final Object lock = new Object();
    private volatile Iterator<Character> lettersIterator;
    private static ArrayList<Character> lettersList;
    private volatile Character currentLetter;

    /**
     * Конструктор класса печати букв
     * @param length кол-во повторений для каждой буквы
     * @param letters массив букв
     */
    PrintLetter(int length, Character... letters) {
        //Смотрим, чтобы не было повторяющихся букв и чтобы была передана хотя бы одна буква
        if (letters.length == 0) throw new IllegalArgumentException("Нужно передать хотя бы одну букву");
        lettersList = new ArrayList<>(Arrays.asList(letters));
        for (Character letter: letters)
            if (lettersList.indexOf(letter) != lettersList.lastIndexOf(letter)) throw new IllegalArgumentException("Все буквы должны быть уникальными");

        //Высчитываем текущую букву по циклическому итератору
        lettersIterator = Iterables.cycle(lettersList).iterator();
        currentLetter = lettersIterator.next();

        //Запускаем потоки
        lettersList.forEach((letter) -> {
            int i = lettersList.indexOf(letter);
            new Thread(()->printLetter(i, length)).start();});
    }

    /**
     * Печать буквы
     * @param letterNum индекс буквы в переданном в конструктор массиве
     * @param length сколько раз надо напечатать букву
     */
    private void printLetter(int letterNum, int length) {
        synchronized (lock) {
            try {
                for (int i = 0; i < length; i++) {
                    while (currentLetter != lettersList.get(letterNum)) lock.wait();
                    System.out.print(lettersList.get(letterNum));

                    //Переводим текущую букву по итератору в следующую
                    currentLetter = lettersIterator.next();

                    //Оповещаем все потоки о том, что можно продолжать работу
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
