package ru.geekbrains.java3.dz.dz4.GoryainovVladimir;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Vladimir on 23.04.2017.
 */
public class Task2 extends Thread {
    private final Object obj = new Object();
    private volatile String str = "src/main/java/ru/geekbrains/java3/" +
            "dz/dz4/GoryainovVladimir/Task2.txt";

    public void run() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(str, true))) {
            for (int i = 0; i < 10; i++) {
                bw.write(getName() + ": ");
                bw.write(str);
                bw.write(System.lineSeparator());
                Thread.sleep(20);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
