package ru.geekbrains.java3.dz.dz5.Alexey_Pavlovich;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    private int capacity;
    final Semaphore semaphore;

    public Tunnel(int capacity) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.capacity = capacity;
        semaphore = new Semaphore(capacity);
    }

    @Override
    public void go(Car c) {
        try {
            try {
                semaphore.acquire();
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
