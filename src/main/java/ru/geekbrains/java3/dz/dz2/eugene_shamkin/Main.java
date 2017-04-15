package ru.geekbrains.java3.dz.dz2.eugene_shamkin;

import java.sql.*;
import java.util.Arrays;

/** Geekbrains.ru
 *  Course name: Java 3
 *  Homework 2, performed by Eugene Shamkin, April 15, 2017
 *  **********************************************************
 */

public class Main {

    public static String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    public static String user = "postgres";
    public static String password = "postgres";
    public static void main(String[] args) {
        createNewTable();
        cleanTable();
        fillTableWithData();
    }

/*  1. Сформировать таблицу товаров (id, prodid, title, cost) запросом из Java приложения.
 *  id - порядковый номер записи, первичный ключ
 *  prodid - уникальный номер товара
 *  title - название товара
 *  cost - стоимость
 */
    private static void createNewTable() {
        Connection conn = null;
        Statement stmt = null;

        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(dbUrl, user, password);
            stmt = conn.createStatement();
            stmt.execute("CREATE TABLE public.\"PRODUCTS\"\n" +
                    "(\n" +
                    "   id integer NOT NULL PRIMARY KEY, \n" +
                    "   prodid integer NOT NULL, \n" +
                    "   title character varying(255), \n" +
                    "   cost money\n" +
                    ") \n" +
                    "WITH (\n" +
                    "  OIDS = FALSE\n" +
                    ")\n" +
                    ";");
            System.out.println("Таблица была успешно создана!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }

/*  2. При запуске приложения очистить таблицу и заполнить 10.000 товаров вида:
 *  id_товара 1 товар1 10
 *  id_товара 2 товар2 20
 *  id_товара 3 товар3 30
 *  ...
 *  id_товара 10000 товар10000 100010
 *  т.е. просто тестовые данныеь
 */
    private static void cleanTable() {
        Connection conn = null;
        Statement stmt = null;

        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(dbUrl, user, password);
            stmt = conn.createStatement();
            stmt.execute("DELETE FROM PRODUCTS;");
            System.out.println("Таблица была очищена!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }

    private static void fillTableWithData() {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(dbUrl, user, password);
            conn.setAutoCommit(false);
            ps = conn.prepareStatement("INSERT INTO PRODUCTS (id, prodid, title, cost) VALUES (?, ?, ?, ?)");
            ps.clearBatch();
            for (int i = 1; i < 10001; i++) {
                ps.setInt(1, i);
                ps.setInt(2, 5000 + i); //формирую уникальный номер товара
                ps.setString(3, "Товар" + i);
                ps.setInt(4, i*10);
                ps.addBatch();
            }
            int[] w = ps.executeBatch();
            System.out.println(Arrays.toString(w));
            conn.commit();
            System.out.println("Таблица была успешно заполнена данными!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }
}
