package ru.geekbrains.java3.dz.dz3.KhoroshavinAndrey;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

/**
 * Created by andrey on 20.04.17.
 */
public class Main {
    private static String DEFAULT_FILE_NAME = "byte";
    private static int PAGE_SIZE = 1800;

    public static void main(String[] args) {

        byte[] f = readByteFile(DEFAULT_FILE_NAME + "1");
        String s = new String(f);
        System.out.println(s);

        //createFiles(DEFAULT_FILE_NAME, f);

        String[] fnames = new String[10];
        for (int i=0; i<10; i++){
            fnames[i] = DEFAULT_FILE_NAME + (i + 1);
        }

        concatFiles(fnames, DEFAULT_FILE_NAME);

        readPage("error.log", 1);


    }

    public static void createFiles(String name, byte[] mas){
        for (int i=1; i<11; i++){
            try (BufferedOutputStream fout = new BufferedOutputStream(new FileOutputStream(name + i))){
                fout.write(mas);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeToFile(String name, byte[] mas) {
        try (BufferedOutputStream fout = new BufferedOutputStream(new FileOutputStream(name))){
            fout.write(mas);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    /////////Задание 1///////////////////////
    public static byte[] readByteFile(String path) {
        ByteArrayOutputStream out = null;
        InputStream input = null;
        try{
            out = new ByteArrayOutputStream();
            input = new BufferedInputStream(new FileInputStream(path));
            int data = 0;
            while ((data = input.read()) != -1){
                out.write(data);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }
 //////////Задание 2////////////////////
    public static void concatFiles(String[] name, String fName){
        ArrayList<FileInputStream> al = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            try {
                al.add(new FileInputStream(name[i]));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Enumeration<FileInputStream> e = Collections.enumeration(al);
        while(e.hasMoreElements()){
            try (BufferedInputStream fin = new BufferedInputStream(e.nextElement())){
                int data = 0;
                while ((data = fin.read()) != -1){
                    out.write(data);
                }
            }catch (IOException error) {
                error.printStackTrace();
            }
        }
        writeToFile(fName, out.toByteArray());
    }
//////////Задание 3/////////////////////////
    public static void readPage(String fPath, int page){
        if (page < 1) page = 1;

        long time0 = System.currentTimeMillis();
        byte[] mas = readByteFile(fPath);
        Integer p = PAGE_SIZE * (page - 1);
        byte[] onePage = new byte[PAGE_SIZE];
        for (int i = 0; i < PAGE_SIZE; i++) {
            onePage[i] = mas[p + i];
        }
        String s = new String(onePage);
        System.out.println(s);
        time0 = System.currentTimeMillis() - time0;
        System.out.println("Время выполнения - " + time0);  ////На моем ноутбуке время выполнения - 2542
    }


}
