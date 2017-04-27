package ru.geekbrains.java3.dz.dz4.dmitrygusev;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * Created by Дмитрий on 22.04.2017.
 * Задача 3. Написать класс МФУ на котором возможны одновременная печать и сканирование документов,
 * при этом нельзя одновременно печатать два документа или сканировать (при печати в консоль выводится сообщения
 * "отпечатано 1, 2, 3,... страницы", при сканировании то же самое только
 * "отсканировано...", вывод в консоль все также с периодом в 50 мс.)
 *
 * МФУ, обрабатывающий запросы на сканирование и печать.
 */
class MFU {

    synchronized ArrayList<Character> scan(File file, int p) throws IOException {
        ArrayList<Character> list = new ArrayList<>();
        final int PAGE_SIZE = 2000;
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        int page = p - 1;
        raf.seek(page * PAGE_SIZE);
        for (int i = 0; i < PAGE_SIZE; i++) {
            list.add((char)raf.read());
        }
        raf.close();
        return list;
    }

    synchronized void print(ArrayList<Character> list, String src) {
        try (FileOutputStream out = new FileOutputStream(src, true)) {
            for (char ch : list) {
                out.write((int)ch);
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

