package ru.geekbrains.java3.lesson4.p1_base;

import ru.geekbrains.java3.lesson4.MyTimer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example_Base_3 {
    public static final int COUNT_THREAD = 10;
    public static final int COUNT_RUN = 100;

    // Создание потоков с помощью ExecutorService

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(COUNT_RUN);
        ExecutorService serv = Executors.newFixedThreadPool(COUNT_THREAD); // Пул, с фиксированным количеством потоков
//        ExecutorService serv = Executors.newCachedThreadPool(); // Пул, который создаем потоки по мере необходимости
//        ExecutorService serv = Executors.newSingleThreadExecutor(); // Пул, только один поток
        MyTimer.start();
        for (int i = 0; i < COUNT_RUN; i++) {
            final int w = i;
            serv.execute(() -> {
            System.out.println(w + " - Begin");
            try {
                Thread.sleep(100 + (int)(3000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(w + " - End");
            cdl.countDown();
        });
        }
        serv.shutdown(); // ExecutorService "Перестает принимать заказы"
        try {
            cdl.await(); // Ждем пока все потоки сделают countDown()
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyTimer.stopAndPrint();
    }
}
