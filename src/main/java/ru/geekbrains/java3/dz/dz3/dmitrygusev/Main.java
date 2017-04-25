package ru.geekbrains.java3.dz.dz3.dmitrygusev;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

/**
 * Created by Дмитрий on 18.04.2017.
 * Домашнее задание №3:

 3) Написать консольное приложение, которое умеет постранично читать текстовые файлы(размером > 10 mb),
 вводим страницу, программа выводит ее в консоль(за страницу можно принимаем 1800 символов).
 Время чтения файла должно находится в разумных пределах(программа не должна загружаться дольше 10 секунд),
 ну и чтение тоже не должно занимать >5 секунд.
 Чтобы не было проблем с кодировкой используйте латинские буквы.
 */
public class Main {

    public static void main(String[] args) {
        //Task1();
        //task2();
        task3();
    }

    /**
     * Задача 1) Прочитать файл(около 50 байт) в байтовый массив и вывести этот массив в консоль; */
    private static void task1() {
        try (FileInputStream in = new FileInputStream("123.txt")) {
            printStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Задача 2. Последовательно сшить 10 файлов в один(файлы также ~100 байт). */
    private static void task2() {
        FileInputStream in = null;
        ArrayList<FileInputStream> al = new ArrayList<>();
        try {
            al.add( new FileInputStream("123.txt"));
            al.add( new FileInputStream("dos.txt"));
            al.add( new FileInputStream("st.txt"));
            al.add( new FileInputStream("file4.txt"));
            al.add( new FileInputStream("5.txt"));
            al.add( new FileInputStream("6.txt"));
            al.add( new FileInputStream("7.txt"));
            al.add( new FileInputStream("8.txt"));
            al.add( new FileInputStream("9.txt"));
            al.add( new FileInputStream("file10.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Enumeration<FileInputStream> e = Collections.enumeration(al);

        try {
            while (e.hasMoreElements()) {
                in = e.nextElement();
                printStream(in);
            }
        } catch (IOException er) {
            er.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
        }
    }

    private static void task3() {
        ArrayList<String> list = loadBook();
        int count = list != null ? list.size() : 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                try {
                    System.out.println("Укажите номер страницы для чтения (1 - " + (count) + ")\n" +
                            "Для выхода из программы введите 0");
                    int pageNum = Integer.parseInt(reader.readLine());
                    if (pageNum == 0) break;
                    System.out.println(list != null ? list.get(pageNum - 1) : null);
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    System.out.println("Неправильно указан номер страницы. Попробуйте еще раз.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<String> loadBook() {
        int size = 1800;    // размер страницы
        int count = 0;      // счетчик
        ArrayList<String> pages = new ArrayList<>();
        try(BufferedReader  reader = new BufferedReader(new FileReader("tales.txt"))) {
            StringBuilder line = new StringBuilder();
            String page;    // страница, которая будет добавлена в список.
            int step;       // итератор
            while((step = reader.read()) != -1) {
                line.append((char)step);
                count++;
                if (count == size) {
                    // пришлось использовать посредника - String для того, чтобы в список заносились разные страницы
                    // если бы я создал ArrayList<String> и приравнивал сразу pages.add(line) то в итоге все страницы
                    // в списке были одинаковыми. были бы равны последней странице. т.к. ссылочная переменная line в
                    // список передавала бы не значения а ссылки на адрес.
                    page = String.valueOf(line);
                    pages.add(page);
                    line.delete(0, line.length());
                    count = 0;
                }
            }
            page = String.valueOf(line);
            pages.add(page);
            return pages;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // прочитать полностью и вывести в консоль поток FileInputStream
    private static void printStream(FileInputStream stream) throws IOException {
        int step;
        int i = 0;
        int length = stream.available();

        byte[] list = new byte[length];
        while ((step = stream.read()) != -1) {
            list[i] = (byte) step;
            i++;
        }

        for (byte b : list) {
            System.out.print((char)b);
        }
    }


}
