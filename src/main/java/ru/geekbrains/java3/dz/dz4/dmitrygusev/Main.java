package ru.geekbrains.java3.dz.dz4.dmitrygusev;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Дмитрий on 21.04.2017.
 * Homework #4
 */
public class Main {
    private final Object obj = new Object();
    private final Object obj2 = new Object();
    private final int count = 5;

    private volatile char currLetter = 'A';
    private volatile int curOrder = 1;


    public static void main(String[] args) {
//        Задача 1. Создать три потока, каждый из которых выводит определенную букву(A, B и C) 5 раз,
//        порядок должен быть именно ABСABСABС
        Main m = new Main();

        Thread t1 = new Thread(m::printA);
        Thread t2 = new Thread(m::printB);
        Thread t3 = new Thread(m::printC);

        t1.start();
        t2.start();
        t3.start();

        // Задача 2. Написать совсем небольшой метод, в котором 3 потока построчно
        // пишут данные в файл (штук по 10 записей, с периодом в 20 мс)
        Main m2 = new Main();

        Thread t4 = new Thread(() -> {
            String msg = "This is data from t4\n";
            char[] data = msg.toCharArray();
            m2.writeInFile(1, data);
        });
        Thread t5 = new Thread(() -> {
            String msg = "This is data from t5\n";
            char[] data = msg.toCharArray();
            m2.writeInFile(2, data);
        });
        Thread t6 = new Thread(() -> {
            String msg = "This is data from t6\n";
            char[] data = msg.toCharArray();
            m2.writeInFile(3, data);
        });


        t4.start();
        t5.start();
        t6.start();


    }

    private void printA() {
        synchronized (obj) {
            try {
                for (int i = 0; i < count; i++) {
                    while (currLetter != 'A')
                        obj.wait();
                    System.out.print("A");
                    currLetter = 'B';
                    obj.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printB() {
        synchronized (obj) {
            try {
                for (int i = 0; i < count; i++) {
                    while (currLetter != 'B')
                        obj.wait();
                    System.out.print("B");
                    currLetter = 'C';
                    obj.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printC() {
        synchronized (obj) {
            try {
                for (int i = 0; i < count; i++) {
                    while (currLetter != 'C')
                        obj.wait();
                    System.out.print("C");
                    currLetter = 'A';
                    obj.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeInFile(int order, char[] data) {
        synchronized (obj2) {
            try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("out.txt", true))) {
                for (int i = 0; i < count * 2; i++) {
                    while (curOrder != order)
                        obj2.wait();
                    for (char ch : data) {
                        out.write((int) ch);
                        System.out.print(ch);
                    }
                    System.out.println();
                    out.flush();
                    Thread.sleep(20);
                    if (curOrder == 3)
                        curOrder = 1;
                    else
                        curOrder++;
                    obj2.notify();
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
