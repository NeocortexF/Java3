package ru.geekbrains.java3.dz.dz4.Alexey_Pavlovich;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class SecondTask {
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
}
