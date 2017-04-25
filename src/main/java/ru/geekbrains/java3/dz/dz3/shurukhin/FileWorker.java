package ru.geekbrains.java3.dz.dz3.shurukhin;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Класс работы с файлом
 */
class FileWorker {
    private String name;
    private OutputStreamWriter fout;
    private DataInputStream finpData;
    private FileOutputStream fous;
    private FileInputStream fins;
    private static final int PAGE_SIZE = 1800;

    FileWorker(String name) throws FileNotFoundException, UnsupportedEncodingException {
        this.name = name;
        fous = new FileOutputStream(this.name, false);
        fout = new OutputStreamWriter(fous, "UTF-8");
        fins = new FileInputStream(this.name);
        finpData = new DataInputStream(new FileInputStream(this.name));
    }

    /**
     * Запись строки в файл
     * @param string строка, которую требуется записать в файл
     */
    private void writeToFile(String string) {
        isFile();
        try {
            fout.write(string);
            fout.flush();
        } catch (IOException е) {
            System.out.println("Произошла ошибка при записи в файл");
        }
    }

    /**
     * Генерация случайной строки. Использует справочник, из которого случайным образом выбираются символы
     * и записываются в строку.
     * @param length длина генерируемой строки
     * @return сгенерированная строка
     */
    private String generateRandomString(int length) {
        final String alphabet = "0123456789\nabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZабвгдеёжзийклмнопрстуфхцчшщьъэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЪЭЮЯ ";
        final int dictNum = alphabet.length();
        Random rand = new Random();
        StringBuilder result = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            result.append(alphabet.charAt(rand.nextInt(dictNum)));
        }
        return result.toString();
    }

    /**
     * Запись в файл случайно сгенерированной строки длиной length
     * @param length длина генерируемой строки
     * @return текущий объект
     */
    FileWorker genRandomFile(int length) {
        this.writeToFile(this.generateRandomString(length));
        return this;
    }

    /**
     * Чтение файла. Возвращает содержимое в виде byte[]
     * @return массив Byte[] с содержимым файла
     */
    Byte[] readFileByte() {
        isFile();
        ArrayList<Byte> result = new ArrayList<>();
        try {
            while (finpData.available() > 0)
                result.add(finpData.readByte());
        } catch (IOException е) {
            System.out.println("Произошла ошибка при чтении файла");
            е.printStackTrace();
        }
        return result.toArray(new Byte[result.size()]);
    }

    /**
     * Чтение файла. Возвращает содержимое в виде String
     * @return String с содержимым файла
     */
    String readFileString() {
        isFile();
        Byte[] fileCont = readFileByte();
        byte[] string = new byte[fileCont.length];
        for (int i = 0; i < fileCont.length; i++) {
            string[i] = fileCont[i];
        }
        return new String(string, StandardCharsets.UTF_8);
    }


    void printFileBytes() {
        System.out.println(Arrays.toString(readFileByte()));
    }

    /**
     * Склеивание файлов.
     * @param file объект FileWorker
     * @return текущий объект
     */
    FileWorker append(FileWorker file) throws IOException {
        ArrayList<Byte> currentBytes = new ArrayList<>(Arrays.asList(this.readFileByte()));
        currentBytes.addAll(Arrays.asList(file.readFileByte()));
        byte[] byteArr = new byte[currentBytes.size()];
        for (int i = 0; i < byteArr.length; i++) {
            byteArr[i] = currentBytes.get(i);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int b;
        while ((b = byteArrayInputStream.read()) != -1) {
            byteArrayOutputStream.write(b);
        }
        byteArrayOutputStream.writeTo(fous);
        byteArrayOutputStream.flush();
        return this;
    }

    /**
     * Чтение страницы файла
     * @param pageNum номер страницы
     * @return строка, содержащая страницу
     */
    String readPage(int pageNum) {
        isFile();
        byte[] result = new byte[PAGE_SIZE];
        int numSkip;
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(this.name))) {
            numSkip = dataInputStream.skipBytes((pageNum - 1) * PAGE_SIZE);
            if (numSkip == (pageNum - 1) * PAGE_SIZE)
                if (dataInputStream.read(result) != -1)
                    return new String(result, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Проверка на файл
     */
    private void isFile () {
        if (!(new File(this.name).isFile())) throw new IllegalArgumentException("Указанный объект не является файлом");
    }

    /**
     * Удаление файла.
     */
    void delete() throws IOException {
        //Закрываем потоки перед удалением
        finpData.close();
        fout.close();
        fins.close();
        File file = new File(this.name);
        if (!file.delete()) {
            System.out.println("Удаление невозможно");
        }
    }
}
