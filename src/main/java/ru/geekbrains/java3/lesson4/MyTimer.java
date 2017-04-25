package ru.geekbrains.java3.lesson4;

/**
 * Created by FlameXander on 23.11.2016.
 */
public class MyTimer {
    private static long t;

    public static void start() {
        t = System.currentTimeMillis();
    }

    public static void stopAndPrint() {
        System.out.println("time: " + (System.currentTimeMillis() - t));
    }
}
