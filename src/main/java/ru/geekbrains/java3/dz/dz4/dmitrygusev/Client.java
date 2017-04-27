package ru.geekbrains.java3.dz.dz4.dmitrygusev;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Дмитрий on 21.04.2017.
 * Задача 3. Написать класс МФУ на котором возможны одновременная печать и сканирование документов,
 * при этом нельзя одновременно печатать два документа или сканировать (при печати в консоль выводится сообщения
 * "отпечатано 1, 2, 3,... страницы", при сканировании то же самое только
 * "отсканировано...", вывод в консоль все также с периодом в 50 мс.)
 *
 * Клиент, обращающийся к МФУ
 */

public class Client {
    private static File file = new File("bible.txt");

    private MFU mfu = new MFU();

    public static void main(String[] args) {
        Client cl = new Client();

        Thread t1 = new Thread(() -> {
            try {
                cl.scanAndPrint(10, 6, "t1.txt");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                cl.scanAndPrint(1, 3, "t2.txt");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.setName("клиент 1");
        t2.setName("клиент 2");
        t1.start();
        t2.start();
    }

    private void scanAndPrint(int offset, int count, String src) throws InterruptedException {
        String name = Thread.currentThread().getName();
        ArrayList<ArrayList<Character>> list = new ArrayList<>();
        String delimiter = "\n#####################################\n";
        for (int i = offset; i < count + offset; i++) {
            try {
                list.add(mfu.scan(file, i));
                Thread.sleep(50);
                System.out.println(delimiter + name + ": Отсканирована страница " + i + delimiter);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < list.size(); i++) {
            mfu.print(list.get(i), src);
            Thread.sleep(50);
            System.out.println(delimiter + name + ": Отпечетано страниц... " + (i + 1) + delimiter);
        }
    }
}
