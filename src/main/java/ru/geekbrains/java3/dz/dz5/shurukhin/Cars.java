package ru.geekbrains.java3.dz.dz5.shurukhin;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * Интерфейс машин
 */
public interface Cars {
    int CARS_COUNT = 13;
    CyclicBarrier startPosition = new CyclicBarrier(CARS_COUNT);
    Semaphore tunnelCapacity = new Semaphore(CARS_COUNT / 2);
    CountDownLatch countStart = new CountDownLatch(CARS_COUNT);
    CountDownLatch countFinish = new CountDownLatch(CARS_COUNT);
    ArrayBlockingQueue<Car> finishers = new ArrayBlockingQueue<>(CARS_COUNT);
}
