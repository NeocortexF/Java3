package ru.geekbrains.java3.dz.dz3.EgorovRoman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ПКПК on 20.04.2017.
 */
public class Third {

    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader reader = new BufferedReader(new FileReader("text.txt"));
//        BufferedReader reader = new BufferedReader(new FileReader("1-10.txt"));

        int a = 0;
        String text = "";
        int i = 0;

        while ((a = reader.read()) != -1){

            text += (char)a;
            i++;
            if (i >= 1800 ){
                System.out.println(text);
                i = 0;
                Thread.sleep(10000); // Читать эту хрень всё равно никто не будет, поэтому 10 сек.
            }




        }

    }
}
