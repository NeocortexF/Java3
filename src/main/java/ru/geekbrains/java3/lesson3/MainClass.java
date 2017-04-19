package ru.geekbrains.java3.lesson3;

import java.io.*;
import java.util.*;

public class MainClass {

    // java.io
    // ---------------------------------------------
    // File, FilenameFilter, mkdir, mkdirs, createNewFile, renameTo(with flag)
    // InputStream, OutputStream
    // FileInputStream, FileOutputStream
    // BufferedInputStream, BufferedOutputStream
    // DataInputStream, DataOutputStream
    // ByteArrayInputStream, ByteArrayOutputStream
    // CharArrayReader, CharArrayWriter
    // PrintStream (to text, System.in, out)
    // PipedInputStream, PipedOutputStream, PipedReader, PipedWriter
    // Reader, Writer
    // FileReader, FileWriter
    // BufferedReader, PrintWriter
    // SequenceInputStream
    // PushBackReader
    // RandomAccessFile
    // ObjectInputStream, ObjectOutputStream (Serializable, Externalizable)


    public static void main(String[] args) {
        File file = new File("cat1/cat2/cat3");
//        dataInOutTest();
//        byteArrayTest();
//        scannerVsBufferedReader();
        objectInOutTest();
    }

    public static void sequenceTest() {
        try {
            SequenceInputStream sin = new SequenceInputStream(new FileInputStream("a1.txt"), new FileInputStream("a2.txt"));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("out.txt"));
            int x;
            while ((x = sin.read()) != -1) {
                out.write(x);
            }
            out.close();
            sin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void scannerVsBufferedReader() {
        try {
            long time;
            time = System.currentTimeMillis();
            BufferedReader br = new BufferedReader(new FileReader("123.txt"));
            while (br.readLine() != null) ;
            br.close();
            System.out.println(System.currentTimeMillis() - time);

            time = System.currentTimeMillis();
            Scanner sc = new Scanner(new FileReader("123.txt"));
            while (sc.hasNext()) {
                sc.nextLine();
            }
            sc.close();
            System.out.println(System.currentTimeMillis() - time);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void pipeTest() {
        BufferedWriter bw = null;
        BufferedReader br = null;
        try {
            bw = new BufferedWriter(new FileWriter("C:\\file.txt"));
            for (int i = 0; i < 100; i++) bw.write("Java");
            bw.close();
            br = new BufferedReader(new FileReader("C:\\file.txt"));
            String s = null;
            while ((s = br.readLine()) != null)
                System.out.println(s);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            PipedInputStream in = new PipedInputStream();
            PipedOutputStream out = new PipedOutputStream();
            out.connect(in);
            for (int i = 0; i < 100; i++) {
                out.write(i);
            }
            int x;
            while ((x = in.read()) != -1) {
                System.out.print(x + " ");
            }
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void byteArrayTest() {
        byte[] b1 = {1, 2, 3, 5, 2, 1};
        ByteArrayInputStream in = new ByteArrayInputStream(b1);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int b;
        while ((b = in.read()) != -1) {
            out.write(b);
        }
        byte[] x = out.toByteArray();
        System.out.println(Arrays.toString(x));
    }

    public static void dataInOutTest() {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("dos.txt"))) {
            out.writeLong(700);
            out.writeLong(100000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("dos.txt")))) {
            System.out.println(in.readLong());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void objectInOutTest() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("st.txt"))) {
            out.writeObject(new Student("name1", "tel"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("st.txt"))) {
           ((Student) in.readObject()).info();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
