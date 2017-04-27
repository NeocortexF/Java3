package ru.geekbrains.java3.dz.dz4.AnosovAlexey;

public class MFD {
    private static final int DELAY = 50;
    
    public void print(final int pageNumber) {
        new Thread(() -> printPages(pageNumber)).start();
    }
    
    private synchronized void printPages(int pageNumber) {
        System.out.print("Напечатано... ");
        for(int i = 0; i < pageNumber; i++) {
            System.out.print((1+i) + ", ");
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("страниц");
    }
    
    public void scan(final int pageNumber) {
        new Thread(() -> scanPages(pageNumber)).start();
    }
    
    private synchronized void scanPages(int pageNumber) {
        System.out.print("Отсканировано... ");
        for(int i = 0; i < pageNumber; i++) {
            System.out.print((1+i) + ", ");
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("страниц");
    }
    
}
