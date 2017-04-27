package ru.geekbrains.java3.dz.dz4.GoryainovVladimir;

public class MainClass {
    public static void main(String[] args) {
        /*Создать 3 потока, каждый из которых выводит определенную букву
        * (А, B и С) 5 раз, порядок должен быть именно ABCABCABC. Используйте
          wait/notify/notifyAll.
        */
        //Класс Task1
        Task1 tsk1 = new Task1();
        Thread t1 = new Thread(() -> tsk1.printA());
        Thread t2 = new Thread(() -> tsk1.printB());
        Thread t3 = new Thread(() -> tsk1.printC());

        t1.start();
        t2.start();
        t3.start();

        /*Написать совсем небольшой метод, в котором 3 потока построчно
        * пишут данные в файл (по 10 записей, с периодом 20 мс).
        */
        //Класс Task2
        Thread t4 = new Thread(new Task2());
        Thread t5 = new Thread(new Task2());
        Thread t6 = new Thread(new Task2());
        t4.start();
        t5.start();
        t6.start();
    }
}
