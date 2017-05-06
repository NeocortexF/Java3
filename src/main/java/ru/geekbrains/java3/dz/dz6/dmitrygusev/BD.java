package ru.geekbrains.java3.dz.dz6.dmitrygusev;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Дмитрий on 01.05.2017.
 */
public class BD {
    private static SQLHandler handler = new SQLHandler("java3");

    public static void main(String[] args) {
        try {
            System.out.println("WAS");
            printList(handler.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static <E> void printList(List<E> list) {
        for (E line : list)
            System.out.println(line);
    }
}
