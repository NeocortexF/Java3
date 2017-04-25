package ru.geekbrains.java3.lesson4.p2_synch_counter;

public class Example_SychCounter_2 {
    public static void main(String[] args) {
        SynchCounter sc = new SynchCounter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                sc.inc();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                sc.dec();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("p2_synch_counter: " + sc.value());
    }
}
