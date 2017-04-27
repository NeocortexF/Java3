package ru.geekbrains.java3.lesson5;

import java.util.concurrent.ArrayBlockingQueue;

public class ProdConsExample {
    static class Producer {
        private ArrayBlockingQueue<String> a;

        public Producer(ArrayBlockingQueue<String> a) {
            this.a = a;
        }

        public void put(String x) {
            try {
                System.out.println("producer add: " + x);
                a.put(x);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer {
        private ArrayBlockingQueue<String> a;

        public Consumer(ArrayBlockingQueue<String> a) {
            this.a = a;
        }

        public String get() {
            try {
                String str = a.take();
                System.out.println("consumer get: " + str);
                return str;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static void main(String[] args) {
        final ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(10);
        new Thread(() -> {
            Producer p = new Producer(abq);
            for (int i = 0; i < 10; i++) {
                try {
                    p.put(String.valueOf(i));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            Consumer c = new Consumer(abq);
            for (int i = 0; i < 10; i++) {
                try {
                    c.get();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
