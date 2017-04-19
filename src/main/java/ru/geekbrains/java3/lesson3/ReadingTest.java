package ru.geekbrains.java3.lesson3;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadingTest {
    public static void main(String[] args) {
        defaultReadVsBuffered();
        readingStringVsStringBuilder();
    }

    public static void defaultReadVsBuffered() {
        String filename = "123.txt";
        StringBuilder sb1 = new StringBuilder("");
        long time0 = System.currentTimeMillis();
        try (FileInputStream in = new FileInputStream(filename)) {
            int x;
            do {
                x = in.read();
                sb1.append((char)x);
            } while (x != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Default reading: " + (System.currentTimeMillis() - time0));
        time0 = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder("");
        //try-with-resources
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(filename))) {
            int x;
            do {
                x = in.read();
                sb2.append((char)x);
            } while (x != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Buffered reading: " + (System.currentTimeMillis() - time0));
    }

    public static  void readingStringVsStringBuilder() {
        String str = "";
        long time0 = System.currentTimeMillis();
        try (FileInputStream in = new FileInputStream("123.txt")) {
            int x;
            do {
                x = in.read();
                str += (char)x;
            } while (x != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("String reading: " + (System.currentTimeMillis() - time0));
        time0 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("");
        try (FileInputStream in = new FileInputStream("123.txt")) {
            int x;
            do {
                x = in.read();
                sb.append((char)x);
            } while (x != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("StringBuilder reading: " + (System.currentTimeMillis() - time0));
    }
}
