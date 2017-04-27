package ru.geekbrains.java3.lesson5.homework;

/**
 * Created by FlameXander on 17.10.txt.2016.
 */
public class Task1 {
    static String str = "A";

    public static void main(String[] args) {
        Object lock = new Object();

        class MyTask implements Runnable {
            private String b;
            private String nextB;

            public MyTask(String b, String nextB) {
                this.b = b;
                this.nextB = nextB;
            }

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (lock) {
                        try {
                            while (!str.equals(b))
                                lock.wait();
                            System.out.print(b);
                            str = nextB;
                            Thread.sleep(1);
                            lock.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        new Thread(new MyTask("A", "B")).start();
        new Thread(new MyTask("B", "C")).start();
        new Thread(new MyTask("C", "D")).start();
        new Thread(new MyTask("D", "E")).start();
        new Thread(new MyTask("E", "A")).start();
    }
}
