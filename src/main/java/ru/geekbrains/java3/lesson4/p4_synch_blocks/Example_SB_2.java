package ru.geekbrains.java3.lesson4.p4_synch_blocks;

public class Example_SB_2 {
    private Object lock1 = new Object();

    public static void main(String[] args) {
        Example_SB_2 e2 = new Example_SB_2();
        System.out.println("Start");
        new Thread(() -> e2.method1()).start();
        new Thread(() -> e2.method1()).start();
    }

    public void method1() {
        System.out.println("Normal part");
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (lock1) { // можно еще synchronize(this)
            System.out.println("Synch block");
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("M2");
    }
}
