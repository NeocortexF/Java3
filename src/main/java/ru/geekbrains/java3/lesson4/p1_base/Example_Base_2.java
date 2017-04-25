package ru.geekbrains.java3.lesson4.p1_base;

public class Example_Base_2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
        t1.setPriority(7);
        t1.setName("ForThread");
//        t1.setDaemon(true);
        t1.start();
    }
}
