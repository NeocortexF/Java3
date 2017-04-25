package ru.geekbrains.java3.dz.dz4.eugene_shamkin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Geekbrains.ru
 * Course name: Java 3
 * Homework 4 performed by Eugene Shamkin, April 25, 2017
 * **********************************************************
 *
 * Написать совсем небольшой метод,
 * в котором 3 потока построчно пишут данные в файл
 * (штук по 10 записей, с периодом в 20 мс)
 */
public class Task2 {

    private static final String OUTPUT_FILE_PATH = "./src/main/resources/dz4/Output.txt";

    public static void execute(){
        cleanOutput();
        createThreads();
    }

    private static void cleanOutput() {
        File outputFile = new File(OUTPUT_FILE_PATH);
        if (outputFile.exists()){
            outputFile.delete();
        }
    }

    private static void createThreads() {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                writeFile();
            }
        } ).start();

        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                writeFile();
            }
        } ).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                writeFile();
            }
        } ).start();
    }

    private static synchronized void writeFile(){
        File outputFile = new File(OUTPUT_FILE_PATH);

        try (OutputStreamWriter streamWriter = new FileWriter(outputFile, true)){
            streamWriter.write(Thread.currentThread().getName() + "\n");
            Thread.currentThread().sleep(20L);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        execute();
    }
}
