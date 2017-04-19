package ru.geekbrains.java3.dz.dz3.eugene_shamkin;

import java.io.*;
import java.util.*;

/**
 * Geekbrains.ru
 * Course name: Java 3
 * Homework 3, performed by Eugene Shamkin, April 19, 2017
 * **********************************************************
 */
public class Main {

    // 1) Прочитать файл(около 50 байт) в байтовый массив и вывести этот массив в консоль;
    private static void readFileAndPrint() throws IOException {

        File file = new File("1.txt");
        int length;
        byte[] tmp = new byte[1024];
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream in = new FileInputStream(file);

        try {
            while ((length = in.read(tmp)) >= 0) {
                out.write(tmp, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in.close();
            out.close();
        }
        System.out.println("task 1:");
        //выводит юникодные значение символов, можно и в char перевести при желании
        System.out.println(Arrays.toString(out.toByteArray()));
        System.out.println();
    }

    // 2) Последовательно сшить 10 файлов в один(файлы также ~100 байт).
    private static void readAndJoin10Files() throws IOException {

        FileInputStream file1 = new FileInputStream("1.txt");
        FileInputStream file2 = new FileInputStream("2.txt");
        FileInputStream file3 = new FileInputStream("3.txt");
        FileInputStream file4 = new FileInputStream("4.txt");
        FileInputStream file5 = new FileInputStream("5.txt");
        FileInputStream file6 = new FileInputStream("6.txt");
        FileInputStream file7 = new FileInputStream("7.txt");
        FileInputStream file8 = new FileInputStream("8.txt");
        FileInputStream file9 = new FileInputStream("9.txt");
        FileInputStream file10 = new FileInputStream("10.txt");

        // пробывад сделать в цикле for - не получилось с конкатенацией имен переменных
        // если будет возможность показать на уроке, как то это возможно сделать?
        ArrayList<FileInputStream> al = new ArrayList<>();
        al.add(file1);
        al.add(file2);
        al.add(file3);
        al.add(file4);
        al.add(file5);
        al.add(file6);
        al.add(file7);
        al.add(file8);
        al.add(file9);
        al.add(file10);
        Enumeration<FileInputStream> e = Collections.enumeration(al);
        SequenceInputStream sis = new SequenceInputStream(e);

        System.out.println("task 2:");
        int oneByte;
        while ((oneByte = sis.read()) != -1) {
            System.out.write(oneByte);
        }
        System.out.flush();
    }

    public static void main(String[] args) throws IOException {
        readFileAndPrint();
        readAndJoin10Files();
    }

}
