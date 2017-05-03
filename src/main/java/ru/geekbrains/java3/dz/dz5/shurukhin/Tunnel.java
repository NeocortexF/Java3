package ru.geekbrains.java3.dz.dz5.shurukhin;

import java.util.concurrent.atomic.AtomicInteger;

class Tunnel extends Stage {
    private static AtomicInteger carsCount = new AtomicInteger(0);
    Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    void go(Car c) {

            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                c.enterTunnel();
                System.out.println("Количество машин в туннеле: " + carsCount.addAndGet(1));
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                c.leaveTunnel();
                System.out.println("Количество машин в туннеле: " + carsCount.addAndGet(-1));
            }

    }
}
