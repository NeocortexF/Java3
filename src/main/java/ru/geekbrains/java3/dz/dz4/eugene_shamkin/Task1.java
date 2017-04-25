package ru.geekbrains.java3.dz.dz4.eugene_shamkin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Geekbrains.ru
 * Course name: Java 3
 * Homework 4 performed by Eugene Shamkin, April 25, 2017
 * **********************************************************
 * <p>
 * Создать три потока, каждый из которых выводит определенную букву(A, B и C) 5 раз,
 * порядок должен быть именно ABСABСABС. Используйте wait/notify/notifyAll.
 */
public class Task1 {

    public static void main(String[] args) {
        ExecutorService serv = Executors.newSingleThreadExecutor();
        Task1 w = new Task1();
        Thread t1 = new Thread(() -> {
            w.printA();
        });
        Thread t2 = new Thread(() -> {
            w.printB();
        });
        Thread t3 = new Thread(() -> {
            w.printC();
        });

        for (int i = 0; i < 3; i++) {
            serv.execute(t1);
            serv.execute(t2);
            serv.execute(t3);
        }
    }

    public void printA() {
        System.out.print("A");
    }

    public void printB() {
        System.out.print("B");
    }

    public void printC() {
        System.out.print("C");
    }

}
