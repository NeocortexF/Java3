package ru.geekbrains.java3.dz.dz5.TintulAnton;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static CountDownLatch signalToFinish;
    private static CountDownLatch signalToStart;


    static {
        CARS_COUNT = 0;
    }
    private CyclicBarrier cyclicBarrier;
    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier cyclicBarrier, CountDownLatch signalToFinish, CountDownLatch signalToStart) {
        this.signalToFinish = signalToFinish;
        this.signalToStart = signalToStart;
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {

        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");

            signalToStart.countDown();
            cyclicBarrier.await();

            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }

            signalToFinish.countDown();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

