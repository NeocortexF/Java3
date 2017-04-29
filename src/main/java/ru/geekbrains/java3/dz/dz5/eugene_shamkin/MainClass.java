package ru.geekbrains.java3.dz.dz5.eugene_shamkin;

// Домашнее задание
// Организуем гонки
// Есть набор правил:
// Все участники должны стартовать одновременно, несмотря на то что на подготовку у каждого уходит разное время
// В туннель не может заехать одновременно больше половину участников(условность)
// Попробуйте все это синхронизировать
// Только после того как все завершат гонку нужно выдать объявление об окончании
// Можете корректировать конструктор машин и добавлять объекты классов из пакета util.concurrent
// исходники копируем в папку со своей домашкой

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MainClass {
    public static final int CARS_COUNT = 4;
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();


    public static void main(String[] args) {
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        synchronized (lock1) {
            System.out.println("ВАЖНОЕ ОБЪЯВЕНИЕ >>> Подготовка!!!");
        }



        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);
        for (int i = 0; i < cars.length; i++) {
            final int currentRacer = i;
            new Thread(() -> {
                try {
                    cars[currentRacer] = new Car(race, 20 + (int) (Math.random() * 10));
                    cb.await();
                    cars[currentRacer].run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЕНИЕ >>> Все участники готовы!!!");


       /* for (int j = 0; j < race.getStages().size(); j++) {
            race.getStages().get(j).go(cars[currentRacer]);
        }*/

        System.out.println("ВАЖНОЕ ОБЪЯВЕНИЕ >>> Гонка началась!!!");

        System.out.println("ВАЖНОЕ ОБЪЯВЕНИЕ >>> Участники заезжают в тоннель!! Ширина тунеля не повзолит проехать более половины участников одновременно!");
        try {
            tunnel();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("ВАЖНОЕ ОБЪЯВЕНИЕ >>> Гонка закончилась!!!");

    }

    private static void tunnel() throws InterruptedException {
        Semaphore semaphore = new Semaphore(CARS_COUNT/2);
        semaphore.acquire();
        try {
            int queue = semaphore.getQueueLength();
            System.out.println("На входе в тоннель скопилась очередь из " + queue + " участников!");
           // System.out.println("Участник номер " + + "проехал тоннель!");
        } finally {
            semaphore.release();
        }
    }
}
