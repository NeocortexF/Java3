package ru.geekbrains.java3.dz.dz4.shurukhin;

import java.io.*;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 2. Написать совсем небольшой метод, в котором 3 потока построчно пишут данные в файл (штук
 * по 10 записей, с периодом в 20 мс)
 */
class FileMultiWriter {
    private volatile File file;
    private static final int TIMEOUT = 20;
    private FileOutputStream fileOutputStream;
    private CountDownLatch cdl;

    /**
     * Конструктор
     *
     * @param name         имя файла
     * @param concurrency  кол-во потоков
     * @param stringNum    кол-во строк на каждый поток
     * @param stringLength длина строки
     */
    FileMultiWriter(String name, int concurrency, int stringNum, int stringLength) {
        file = new File(name);
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        cdl = new CountDownLatch(concurrency);
        ExecutorService serv = Executors.newFixedThreadPool(concurrency);
        for (int i = 0; i < concurrency; i++) {
            serv.execute(() -> {
                for (int j = 0; j < stringNum; j++) {
                    printToFile(stringLength);
                }
                cdl.countDown();
            });
        }
        serv.shutdown();
        try {
            cdl.await();
            fileOutputStream.close();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод печати строки в файл
     *
     * @param stringLength длина строки
     */
    private synchronized void printToFile(int stringLength) {
        try {
            OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream, "UTF-8");
            writer.write(generateRandomString(stringLength) + '\n');
            writer.flush();
            try {
                Thread.sleep(TIMEOUT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод генерации случайной строки по заданному алфавиту
     *
     * @param length джлина строки
     * @return случайно сгенерированная строка
     */

    private String generateRandomString(int length) {
        final String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZабвгдеёжзийклмнопрстуфхцчшщьъэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЪЭЮЯ";
        final int dictNum = alphabet.length();
        Random rand = new Random();
        StringBuilder result = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            result.append(alphabet.charAt(rand.nextInt(dictNum)));
        }
        return result.toString();
    }

    /**
     * Удаление файла.
     */
    void delete() {
        if (!file.delete()) {
            System.out.println("Удаление невозможно");
        }
    }
}
