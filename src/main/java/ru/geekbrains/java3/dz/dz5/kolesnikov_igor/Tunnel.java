package ru.geekbrains.java3.dz.dz5.kolesnikov_igor;

import static ru.geekbrains.java3.dz.dz5.kolesnikov_igor.MainClass.CARS_COUNT;
import static ru.geekbrains.java3.dz.dz5.kolesnikov_igor.MainClass.cb;
import static ru.geekbrains.java3.dz.dz5.kolesnikov_igor.MainClass.smp;

public class Tunnel extends Stage {
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                smp.acquire(CARS_COUNT/2);
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 5000);
                smp.release(CARS_COUNT/2);
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
