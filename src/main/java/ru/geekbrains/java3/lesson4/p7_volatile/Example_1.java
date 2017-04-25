package ru.geekbrains.java3.lesson4.p7_volatile;

public class Example_1 {
    static volatile int x = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 400; i++) {
                    x++;
                    System.out.println("write: " + x);
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 400; i++) {
                    System.out.println("read: " + x);
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        });
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("main: " + x);
    }


}
