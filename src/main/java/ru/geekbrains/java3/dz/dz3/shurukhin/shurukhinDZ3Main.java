package ru.geekbrains.java3.dz.dz3.shurukhin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Домашнее задание:
 */
class shurukhinDZ3Main {
    public static void main(String[] args) {
        firstTask();

        secondTask();

        thirdTask();
    }

    /**
     * 1) Прочитать файл(около 50 байт) в байтовый массив и вывести этот массив в консоль;
     */
    private static void firstTask() {
        try {
            //Создаем файл ~50 байт
            FileWorker firstFile = new FileWorker("50bytes1.txt");
            firstFile.genRandomFile(50);
            //Читаем побайтово, выводим массив в консоль
            firstFile.printFileBytes();
            //Удаляем
            firstFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 2) Последовательно сшить 10 файлов в один(файлы также ~100 байт).
     * Может пригодиться следующая конструкция:
     * ArrayList<FileInputStream> al = new ArrayList<>();
     * ...
     * Enumeration<FileInputStream> e = Collections.enumeration(al);
     */
    private static void secondTask() {
        //Создаем список из 10 файлов
        FileEnumCollection files = new FileEnumCollection(10, 100);
        files.printJoinedFile();
        files.deleteAll();
    }

    /**
     * 3) Написать консольное приложение, которое умеет постранично читать текстовые файлы(размером > 10 mb),
     * вводим страницу, программа выводит ее в консоль(за страницу можно принимаем 1800 символов).
     * Время чтения файла должно находится в разумных пределах(программа не должна загружаться дольше 10 секунд),
     * ну и чтение тоже не должно занимать >5 секунд.
     * Чтобы не было проблем с кодировкой используйте латинские буквы.
     */
    private static void thirdTask() {
        try {
            long time;
            FileWorker tenMbFile = new FileWorker("10mb.txt");
            //Создаем файл размером > 10Mb

            time = System.currentTimeMillis();
            tenMbFile.genRandomFile(10485760);
            System.out.println("Время на создание файла = " + (System.currentTimeMillis() - time) + "мс");
            System.out.println("Постраниченое чтение файла > 10Mb");
            thirdInput(tenMbFile);

            tenMbFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void thirdInput(FileWorker file) {
        try (BufferedReader reader = new BufferedReader( new InputStreamReader (System.in))) {
            System.out.print("Введите номер страницы (1 - первая, QUIT - выход): ");
            String choice = reader.readLine();
            StringBuilder result = new StringBuilder("Страница №");
            long time;
            switch (choice) {
                case "QUIT":
                    System.out.println("Завершение работы программы");
                    return;
                default:
                    if (!choice.matches("^[0-9]{1,10}$") || Long.parseLong(choice) > 2147483647) {
                        System.out.println("Некорректный номер страницы");
                        thirdInput(file);
                        break;
                    }
                    time = System.currentTimeMillis();
                    String page = file.readPage(Integer.parseInt(choice));
                    System.out.println(result.append(choice).append('\n').append((!page.equals("") ? page : "Страница не найдена")).append('\n'));
                    //System.out.println("Страница №" + choice + '\n' + (!page.equals("") ? page : "Страница не найдена") + '\n');
                    System.out.println("Время на чтение страницы = " + (System.currentTimeMillis() - time) + "мс");
                    thirdInput(file);
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
