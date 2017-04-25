package ru.geekbrains.java3.lesson4.p2_synch_counter;

public class Example_Counter_1 {
    public static void main(String[] args) {
//        Counter counter = new Counter();
//        Thread t1 = new Thread(() -> {
//            for (int i = 0; i < 100; i++) {
//                counter.inc();
//                try {
//                    Thread.sleep(5);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Thread t2 = new Thread(() -> {
//            for (int i = 0; i < 100; i++) {
//                counter.dec();
//                try {
//                    Thread.sleep(5);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        try {
//            t1.start();
//            t2.start();
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("counter: " + counter.value());
//
        SynchCounter sc = new SynchCounter();
        Thread st1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                sc.inc();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread st2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                sc.dec();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            st1.start();
            st2.start();
            st1.join();
            st2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("synch p2_synch_counter: " + sc.value());
    }
}
