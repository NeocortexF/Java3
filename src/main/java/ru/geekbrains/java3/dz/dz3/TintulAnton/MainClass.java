package ru.geekbrains.java3.dz.dz3.TintulAnton;

/**
 * Created by 1 on 19.04.2017.
 */

import java.io.*;

import java.util.*;

public class MainClass {

    public static void main(String[] args) {

        //Task 1

        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("123.txt"))) {
            byte[] arr = new byte[50];
            bufferedInputStream.read(arr);
            System.out.println(Arrays.toString(arr));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Task 2
        SequenceInputStream sequenceInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {

            ArrayList<FileInputStream> arrayList = new ArrayList<>();

            for (int i = 1; i <= 2; i++) {
                FileInputStream in = new FileInputStream(i + ".txt");
                arrayList.add(in);
            }

            Enumeration<FileInputStream> enumeration = Collections.enumeration(arrayList);

            sequenceInputStream = new SequenceInputStream(enumeration);

            fileOutputStream = new FileOutputStream("123.txt");
            int x;
            do {
                x = sequenceInputStream.read();
                fileOutputStream.write(x);
            } while (x != -1);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                sequenceInputStream.close();
                fileOutputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Task 3
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("123.txt"))) {

            int x = 0;
            long time = System.currentTimeMillis();

            StringBuilder stringBuilder = new StringBuilder("");
            int pages = 1;

            while (x != -1) {

                stringBuilder.append("Page #" + pages + ": \n");

                for (int i = 1; i <= 1800; i++) {

                    x = bufferedInputStream.read();
                    if (x == -1) break;
                    stringBuilder.append((char) x);
                }
                stringBuilder.append("\nEnd of " + pages + " page\n");
                pages++;
            }

            System.out.println(System.currentTimeMillis() - time);
            System.out.println(stringBuilder);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
