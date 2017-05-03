package ru.geekbrains.java3.dz.dz5.shurukhin;

class Car implements Runnable, Cars {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    String getName() {
        return name;
    }

    int getSpeed() {
        return speed;
    }

    Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            countStart.countDown();
            startPosition.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        countFinish.countDown();
        finishers.add(this);
    }

    void enterTunnel() {
        try {
            tunnelCapacity.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void leaveTunnel() {
        tunnelCapacity.release();
    }
}

