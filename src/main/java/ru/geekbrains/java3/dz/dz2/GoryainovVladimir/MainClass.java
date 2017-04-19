package ru.geekbrains.java3.dz.dz2.GoryainovVladimir;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Vladimir on 15.04.2017.
 */
public class MainClass {
    public static void main(String[] args) {

        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            //Соединение с БД
            SQLQueries.connection();

            //Сформировать таблицу товров
            SQLQueries.createTableProducts();

            //Очистка таблицы
            SQLQueries.clearTableProducts();

            //Заполнение таблицы 10.000 товарами
            SQLQueries.fillTableProducts();

            String s;
            do {
                System.out.println("Чтобы узнать цену товара введите:");
                System.out.println("/цена наименование товара");
                System.out.println();
                System.out.println("Чтобы изменить цену товара введите:");
                System.out.println("/сменитьцену \"наименование товара\" \"новая цена\"");
                System.out.println();
                System.out.println("Чтобы посмотреть товары в заданном диапазоне введите:");
                System.out.println("/товарыпоцене цена1 цена2");
                System.out.println();
                System.out.println("end завершить работу");
                System.out.println();
                Scanner sc = new Scanner(System.in);
                s = sc.nextLine();
                String[] w = s.split(" ");

                switch (w[0]) {
                    case "/цена":
                        if (SQLQueries.isProductTrue(w[1])) {
                            SQLQueries.costProduct(w[1]);
                        } else {
                            System.out.println("Такого товара не существует.");
                        }
                        break;

                    case "/сменитьцену":
                            if (SQLQueries.isProductTrue(w[1])) {
                                SQLQueries.changeCostProduct(w[1], Integer.parseInt(w[2]));
                            } else {
                                System.out.println("Такого товара не существует.");
                            }
                        break;

                    case "/товарыпоцене":
                        SQLQueries.presetRangeCosts(Integer.parseInt(w[1]), Integer.parseInt(w[2]));
                        System.out.println();
                        break;

                    case "end":
                        System.out.println("Работа программы завершена.");
                        break;

                    default:
                        System.out.println("Не верно введен запрос.");
                }
            } while (!s.equals("end"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}