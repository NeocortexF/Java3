package ru.geekbrains.java3.dz.dz4.Alexey_Pavlovich;

public class FirstTask {

    private static final Object lock = new Object();
    private static volatile char currentLetter = 'A';

    public static void execute(){
        new Thread(() -> printA()).start();
        new Thread(() -> printB()).start();
        new Thread(() -> printC()).start();
    }

    private static void printA(){
        synchronized (lock) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'A'){
                        lock.wait();
                    }

                    System.out.print("A");
                    currentLetter = 'B';
                    lock.notifyAll();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private static void printB(){
        synchronized (lock) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B'){
                        lock.wait();
                    }

                    System.out.print("B");
                    currentLetter = 'C';
                    lock.notifyAll();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private static void printC(){
        synchronized (lock) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'C'){
                        lock.wait();
                    }

                    System.out.print("C");
                    currentLetter = 'A';
                    lock.notifyAll();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
