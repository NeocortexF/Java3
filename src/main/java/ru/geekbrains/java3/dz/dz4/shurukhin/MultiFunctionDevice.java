package ru.geekbrains.java3.dz.dz4.shurukhin;

/**
 * 3. Написать класс МФУ на котором возможны одновременная печать и сканирование
 * документов, при этом нельзя одновременно печатать два документа или сканировать (при
 * печати в консоль выводится сообщения "отпечатано 1, 2, 3,... страницы", при сканировании то
 * же самое только "отсканировано...", вывод в консоль все также с периодом в 50 мс.)
 */
class MultiFunctionDevice {
    private final Object lockPrint = new Object();
    private final Object lockScan = new Object();
    private final static int TIMEOUT = 50;

    MultiFunctionDevice(int printCount, int scanCount) {
        for (int i = 0; i < printCount; i++) {
            new Thread(() -> {
                synchronized (lockPrint) {
                    try {
                        Thread.sleep(TIMEOUT);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("отпечатано 1, 2, 3,... страницы");
                }
            }).start();
        }
        for (int i = 0; i < scanCount; i++) {
            new Thread(() -> {
                synchronized (lockScan) {
                    try {
                        Thread.sleep(TIMEOUT);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("отсканировано 1, 2, 3,... страницы");
                }
            }).start();
        }
    }
}
