package ru.geekbrains.java3.dz.dz5.AnosovAlexey;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private Semaphore sem;
    
    public Tunnel(int carCount) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        sem = new Semaphore(carCount/2, true);
    }

    @Override
    public void go(Car c) {
        try {
            try {
                if (!sem.tryAcquire())
                    System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                sem.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
