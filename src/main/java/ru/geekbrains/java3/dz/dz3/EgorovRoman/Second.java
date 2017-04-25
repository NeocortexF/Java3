package ru.geekbrains.java3.dz.dz3.EgorovRoman;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

/**
 * Created by ПКПК on 20.04.2017.
 */
public class Second {

    public static void main(String[] args) throws IOException {
        FileInputStream in1 = null,
                in2 = null,
                in3 = null,
                in4 = null,
                in5 = null,
                in6 = null,
                in7 = null,
                in8 = null,
                in9 = null,
                in10 = null;

        in1 = new FileInputStream("1.txt");
        in2 = new FileInputStream("2.txt");
        in3 = new FileInputStream("3.txt");
        in4 = new FileInputStream("4.txt");
        in5 = new FileInputStream("5.txt");
        in6 = new FileInputStream("6.txt");
        in7 = new FileInputStream("7.txt");
        in8 = new FileInputStream("8.txt");
        in9 = new FileInputStream("9.txt");
        in10 = new FileInputStream("10.txt");

        ArrayList<FileInputStream> list = new ArrayList<FileInputStream>();
        list.add(in1);
        list.add(in2);
        list.add(in3);
        list.add(in4);
        list.add(in5);
        list.add(in6);
        list.add(in7);
        list.add(in8);
        list.add(in9);
        list.add(in10);



        Enumeration<FileInputStream> enumeration = Collections.enumeration(list);

        SequenceInputStream sequenceInputStream = new SequenceInputStream(enumeration);

        FileOutputStream outputStream = new FileOutputStream("1-10.txt");

        int a = 0;
        while ((a = sequenceInputStream.read()) != -1) outputStream.write(a);




    }
}
