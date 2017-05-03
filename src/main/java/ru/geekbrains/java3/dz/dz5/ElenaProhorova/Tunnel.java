package ru.geekbrains.java3.dz.dz5.ElenaProhorova;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    public Tunnel(int n) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.smp = new Semaphore(n);
    }

    @Override
    public void go(Car c) {
        try {
            try {
                smp.acquire();
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                smp.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
