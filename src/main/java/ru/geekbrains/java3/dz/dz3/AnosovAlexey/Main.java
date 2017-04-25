package ru.geekbrains.java3.dz.dz3.AnosovAlexey;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Scanner;

public class Main {
    
    public static final int PAGE_SIZE = 1800;

    public static void main(String[] args) {
        System.out.println("Задание 1");
        byte[] br = new byte[50];
        FileInputStream in = null;
        File file1 = new File("file1");
        try {
            in = new FileInputStream(file1);
            while((in.read(br)) != -1) System.out.print(new String(br));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        System.out.println("");
        System.out.println("Задание 2");
        File dir = new File("./");
        File result = new File("result");
        File[] files = dir.listFiles(new DzFileFilter());
        SequenceInputStream seq = null;
        FileOutputStream out = null;
        ArrayList<FileInputStream> al = new ArrayList<>();
        try {
            for (int i = 0; i < files.length; i++) al.add(new FileInputStream(files[i]));
            Enumeration<FileInputStream> en = Collections.enumeration(al);
            seq = new SequenceInputStream(en);
            out = new FileOutputStream(result);
            while (seq.read(br) != -1) out.write(br);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                seq.close();
                out.close();
                for (FileInputStream fin:al) {
                    fin.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        System.out.println("");
        System.out.println("Задание 3");
        File book = new File("book");
        BufferedInputStream bin = null;
        Scanner sc = null;
        int page = 0;
        try {
            bin = new BufferedInputStream (new FileInputStream(book));
            sc = new Scanner(System.in);
            System.out.print("Введите номер страницы: ");
            page = sc.nextInt();
            printPage(page, bin);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                bin.close();
                sc.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
    }
    
    public static void printPage(int page, BufferedInputStream in) {
        try {
            byte[] buf = new byte[PAGE_SIZE];
            int count = 1;
            while(in.read(buf) != -1) {
                if (count == page) {
                    System.out.println(new String(buf));
                    return;
                }
                count++;
            }
            System.out.println("Введенная страница не найдена!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
