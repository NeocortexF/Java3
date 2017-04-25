package ru.geekbrains.java3.dz.dz3.EgorovRoman;

import java.io.*;

/**
 * Created by ПКПК on 20.04.2017.
 */
public class First {

    public static void main(String[] args) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream("ff1.txt"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int data = 0;

        while ((data = is.read()) != -1) bos.write(data);

        byte[] array = bos.toByteArray();

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
