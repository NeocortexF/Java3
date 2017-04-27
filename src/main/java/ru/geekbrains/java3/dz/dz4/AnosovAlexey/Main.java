package ru.geekbrains.java3.dz.dz4.AnosovAlexey;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    private final Object mon = new Object();
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        Main app = new Main();
        app.task1();
        app.task2();
        app.task3();
    }

    private  void task1() {
        try {
            Thread thread1 = new Thread(() -> printLetter('A'));
            Thread thread2 = new Thread(() -> printLetter('B'));
            Thread thread3 = new Thread(() -> printLetter('C'));
            
            thread1.start();
            thread2.start();
            thread3.start();
            
            thread1.join();
            thread2.join();
            thread3.join();
            System.out.println("\nЗадание 1 завершено.");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    private void printLetter(char letter) {
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                try {
                    while (currentLetter != letter) mon.wait();
                    System.out.print(letter);
                    switch (letter) {
                        case 'A':
                            currentLetter = 'B';
                            break;
                        case 'B':
                            currentLetter = 'C';
                            break;
                        case 'C':
                            currentLetter = 'A';
                            break;
                        default:
                            System.out.println("Недопустимы символ: " + letter);
                            break;
                    }
                    mon.notifyAll();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private void task2() {
        try {
            final BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("threads_output"));
            
            Thread thread1 = new Thread(() -> printToFile("Thread1", out));
            Thread thread2 = new Thread(() -> printToFile("Thread2", out));
            Thread thread3 = new Thread(() -> printToFile("Thread3", out));
            
            thread1.start();
            thread2.start();
            thread3.start();
            
            thread1.join();
            thread2.join();
            thread3.join();
            
            System.out.println("Задание 2 завершено: запись в файл завершена");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } 
    }
    
    private synchronized void printToFile(String threadName, BufferedOutputStream out){
        for (int i = 0; i < 10; i++) {
            try {
                out.write((threadName +": " + (i+1) + " запись\n").getBytes());
                out.flush();
                Thread.sleep(20);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void task3() {
        System.out.println("Создаем МФУ");
        MFD mfd = new MFD();
        mfd.print(10);
        mfd.scan(4);
        mfd.print(8);
        mfd.scan(7);
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Задание 3 завершено.");
    }
     
}
