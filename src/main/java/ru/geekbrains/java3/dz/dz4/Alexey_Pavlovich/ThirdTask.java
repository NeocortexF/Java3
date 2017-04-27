package ru.geekbrains.java3.dz.dz4.Alexey_Pavlovich;

public class ThirdTask {
    private static final Object printerLock = new Object();
    private static final Object scanerLock = new Object();

    public static void execute(){
        new Thread(()->{
            print(10);
        }).start();

        new Thread(()->{
            print(10);
        }).start();

        new Thread(()->{
            scan(10);
        }).start();

        new Thread(()->{
            scan(10);
        }).start();
    }

    private static void print(int nPages){
        synchronized (printerLock) {
            for (int i = 1; i <= nPages; i++) {
                System.out.println("Поток: " + Thread.currentThread().getName() + " Напечатано " + i + " страницы.");
                try {
                    Thread.currentThread().sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void scan(int nPages){
        synchronized (scanerLock) {
            for (int i = 1; i <= nPages; i++) {
                System.out.println("Поток: " + Thread.currentThread().getName() + " Отсканировано " + i + " страницы");
                try {
                    Thread.currentThread().sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
