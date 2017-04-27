package ru.geekbrains.java3.lesson5;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    static AtomicInteger x = new AtomicInteger(0);
    public static void main(String[] args) {
        final int THREADS_COUNT = 5; // кол-во потоков
        final int TICKS_COUNT = 20; // количество "тиков" в каждом потоке
        CountDownLatch cdl = new CountDownLatch(THREADS_COUNT);
        for (int q = 0; q < THREADS_COUNT; q++) {
            new Thread(() -> {
                for (int i = 0; i < TICKS_COUNT; i++) {
                    try {
                        Thread.sleep(3); // усыпляем поток на 3 мс.
                        x.getAndAdd(1); // увеличиваем значение AtomicInteger на 1
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                cdl.countDown(); // как только поток все посчитал - уменьшаем счетчик
            }).start();
        }

        try {
            cdl.await(); // ждем пока оба потока выполнят все действия
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("x: " + x); // гарантированно получим THREADS_COUNT * TICKS_COUNT
    }
}
