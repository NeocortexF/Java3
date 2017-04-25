package ru.geekbrains.java3.lesson4;

// Домашнее задание:
// 1) Прочитать файл(около 50 байт) в байтовый массив и вывести этот массив в консоль;
// 2) Последовательно сшить 10 файлов в один(файлы также ~100 байт).
// Может пригодиться следующая конструкция:
// ArrayList<FileInputStream> al = new ArrayList<>();
// ...
// Enumeration<FileInputStream> e = Collections.enumeration(al);
// 3) Написать консольное приложение, которое умеет постранично читать текстовые файлы(размером > 10 mb),
// вводим страницу, программа выводит ее в консоль(за страницу можно принимаем 1800 символов).
// Время чтения файла должно находится в разумных пределах(программа не должна загружаться дольше 10 секунд),
// ну и чтение тоже не должно занимать >5 секунд.
// Чтобы не было проблем с кодировкой используйте латинские буквы.

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class HomeWork3 {
    public static void main(String[] args) {
        try {
            task1();
            // task2();
            // task3();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void task3() throws IOException {
        final int PAGE_SIZE = 1800;
        RandomAccessFile raf = new RandomAccessFile("1.txt", "rw");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter page:");
        int p = sc.nextInt() - 1;
        raf.seek(p * PAGE_SIZE);
        for (int i = 0; i < PAGE_SIZE; i++) {
            System.out.print((char)raf.read());
        }
        raf.close();
    }

    public static void task2() throws IOException {
        ArrayList<InputStream> al = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            al.add(new FileInputStream(i + ".txt"));
        }
        BufferedInputStream in = new BufferedInputStream(new SequenceInputStream(Collections.enumeration(al)));
        int x;
        while((x = in.read()) != -1) {
            System.out.print((char)x);
        }
        in.close();
    }

    public static void task1() throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("2.txt"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int x;
        while((x = in.read()) != -1) {
            out.write(x);
        }
        byte[] b = out.toByteArray();
        System.out.println(Arrays.toString(b));
        in.close();
        out.close();
    }
}
