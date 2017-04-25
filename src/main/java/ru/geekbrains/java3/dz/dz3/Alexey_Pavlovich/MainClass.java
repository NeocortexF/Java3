package ru.geekbrains.java3.dz.dz3.Alexey_Pavlovich;

import com.sun.xml.internal.stream.writers.UTF8OutputStreamWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class MainClass {

    public static void main(String[] args) {
        firstTask();
        secondTask();
        thirdTask();
    }

    private static void firstTask(){
        byte[] fileContent = readFile();
        print(fileContent);
    }

    private static void print(byte[] array){
        for (byte anArray : array) {
            System.out.print((char) anArray);
        }
    }

    private static byte[] readFile() {
        byte[] fileContent = new byte[0];

        try (FileInputStream inputStream = new FileInputStream("./src/main/resources/dz3/Task1Files/SomeTextFile.txt")
        ){
            fileContent = new byte[inputStream.available()];
            inputStream.read(fileContent, 0, inputStream.available());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileContent;
    }

    private static void secondTask() {
        try (FileOutputStream outputStream = new FileOutputStream("./src/main/resources/dz3/Task2Files/Output.txt");
             SequenceInputStream sequenceInputStream = new SequenceInputStream(createInputStreams())
        ){
            int rb;
            while ((rb = sequenceInputStream.read()) != -1) {
                outputStream.write(rb);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Enumeration<FileInputStream> createInputStreams(){
        ArrayList<FileInputStream> inputStreams = new ArrayList<>();
        File dir =  new File("./src/main/resources/dz3/Task2Files/");
        for (File file:dir.listFiles()) {
            if (!file.getName().equals("Output.txt")) {
                try {
                    inputStreams.add(new FileInputStream(file));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        return Collections.enumeration(inputStreams);
    }

    private static void thirdTask(){
        createBigInputFile();
        readWithBuffer();
    }

    private static void createBigInputFile() {

        File inputFile = new File("./src/main/resources/dz3/Task3Files/Input.txt");
        if (inputFile.exists()){
            return;
        }

        System.out.println("Генерация тестовых данных");
        try(FileOutputStream outputStream = new FileOutputStream(inputFile);
            UTF8OutputStreamWriter streamWriter = new UTF8OutputStreamWriter(outputStream)
        ){
            for (int i = 0; i < 900_000; i++) {
                streamWriter.write(String.valueOf(Math.random()) + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readWithBuffer(){
        try(BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("./src/main/resources/dz3/Task3Files/Input.txt"))
        ){
            int pageSize = 1800;
            byte[] bytes = new byte[pageSize];
            while (inputStream.available() > 0 ){
               inputStream.read(bytes, 0, pageSize);
                print(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
