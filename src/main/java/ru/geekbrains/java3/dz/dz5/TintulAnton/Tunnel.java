package ru.geekbrains.java3.dz.dz5.TintulAnton;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    private Semaphore smp;

    public Tunnel(Semaphore smp) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.smp = smp;
    }

    @Override
    public void go(Car c) {
        try {
            try {
                smp.acquire();
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
                smp.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
