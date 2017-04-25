package ru.geekbrains.java3.dz.dz4.eugene_shamkin;

/**
 * Geekbrains.ru
 * Course name: Java 3
 * Homework 4 performed by Eugene Shamkin, April 25, 2017
 * **********************************************************
 *
 * Создать три потока, каждый из которых выводит определенную букву(A, B и C) 5 раз,
 * порядок должен быть именно ABСABСABС. Используйте wait/notify/notifyAll.
 */
public class Task1 {

    private final Object mon = new Object();
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        Task1 w = new Task1();
        Thread t1 = new Thread(() -> { w.printA();
        });
        Thread t2 = new Thread(() -> { w.printB();
        });
        Thread t3 = new Thread(() -> { w.printC();
        });
        t1.start();
        t2.start();
        t3.start();
    }
        public void printA() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 3; i++) {
                    while (currentLetter != 'A') mon.wait();
                    System.out.print("A");
                    currentLetter = 'B';
                    mon.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 3; i++) {
                    while (currentLetter != 'B')
                        mon.wait(); System.out.print("B");
                        currentLetter = 'C';
                        mon.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void printC() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 3; i++) {
                    while (currentLetter != 'C')
                        mon.wait(); System.out.print("C");
                    currentLetter = 'A'; mon.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
