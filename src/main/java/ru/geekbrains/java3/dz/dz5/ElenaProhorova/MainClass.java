package ru.geekbrains.java3.dz.dz5.ElenaProhorova;

// Домашнее задание
// Организуем гонки
// Есть набор правил:
// Все участники должны стартовать одновременно, несмотря на то что на подготовку у каждого уходит разное время
// В туннель не может заехать одновременно больше половину участников(условность)
// Попробуйте все это синхронизировать
// Только после того как все завершат гонку нужно выдать объявление об окончании
// Можете корректировать конструктор машин и добавлять объекты классов из пакета util.concurrent
// исходники копируем в папку со своей домашкой

import java.util.concurrent.*;
import java.util.concurrent.CyclicBarrier;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);
    public final static CountDownLatch cdl = new CountDownLatch(CARS_COUNT);

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT/2), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cb, cdl);
        }

        for (int i = 0; i < cars.length; i++) {
           new Thread(cars[i]).start();
        }

        try {
        Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        while(true) {
            try {
                if (cb.getNumberWaiting()==0) {
                    Thread.sleep(10);
                    System.out.println("ВАЖНОЕ ОБЪЯВЕНИЕ >>> Гонка началась!!!");
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

//            for ( int i = 0; i < cars.length; i++) {
//                try {
//                    t[i].join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            System.out.println("ВАЖНОЕ ОБЪЯВЕНИЕ >>> Гонка закончилась!!!");
        }
    }
