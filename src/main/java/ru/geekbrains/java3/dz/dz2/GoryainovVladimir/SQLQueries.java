package ru.geekbrains.java3.dz.dz2.GoryainovVladimir;

import java.sql.*;

/**
 * Created by Vladimir on 16.04.2017.
 */
public class SQLQueries {
    private static String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    private static String user = "postgres";
    private static String password = "postgres";
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static Statement stmt = null;

    //Метод соединения с базой данных
    public static void connection() {
        try {
            conn = DriverManager.getConnection(dbUrl, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Метод создания таблицы, если она еще не была создана
    public static void createTableProducts() {
        String w = null;
        try {
            stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS products (" +
                    "id INTEGER NOT NULL," +
                    "prodid INTEGER," +
                    "title text," +
                    "cost NUMERIC(8,2)," +
                    "CONSTRAINT products_pkey PRIMARY KEY (id)," +
                    "CONSTRAINT products_prodid_key UNIQUE (prodid));");
        } catch (SQLException e) {
            System.out.println("SQL Exception. Таблица не создана");
        }
    }

    //Метод очистки таблицы
    public static void clearTableProducts() {
        try {
            stmt = conn.createStatement();
            stmt.execute("DELETE FROM products;");
        } catch (SQLException e) {
            System.out.println("SQL Exception. Запрос не выполнен.");
        }
    }

    //Метод заполнения таблицы 10.000 товарами
    public static void fillTableProducts() {
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement("INSERT INTO products (id, prodid, title, cost) VALUES (?, ?, ?, ?);");
            ps.clearBatch();
            for (int i = 1; i <= 10000; i++) {
                ps.setInt(1, i);
                ps.setInt(2, i);
                ps.setString(3, "товар" + i);
                ps.setDouble(4, i * 10);
                ps.addBatch();
            }
            ps.executeBatch();
            conn.commit();
        } catch (SQLException e) {
            System.out.println("SQL Exception. Запрос не выполнен.");
        }
    }

    //Метод проверки на наличие товара в базе данных
    public static boolean isProductTrue(String title) {
        ResultSet rs = null;
        String titles = null;
        try {
            ps = conn.prepareStatement("SELECT title FROM products WHERE title = ?;");
            ps.setString(1, title);
            rs = ps.executeQuery();
            if (rs.next()) {
                titles = rs.getString("title");
                if (titles.contentEquals(title)) return true;
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception. Запрос не выполнен.");
        }
        return false;
    }

    //Метод получения цены выбранного товара
    public static void costProduct(String title) {
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("SELECT title, cost FROM products WHERE title = ?;");
            ps.setString(1, title);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.print("Стоимость товара: " + rs.getString("title") + " равна ");
                System.out.printf("%.2f", rs.getDouble("cost"));
                System.out.println(" у.е." + "\n");
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception. Запрос не выполнен.");
        }
    }

    //Метод изменения цены товара
    public static void changeCostProduct(String title, double cost) {
        try {
            ps = conn.prepareStatement("UPDATE products SET cost = ? WHERE title = ?;");
            ps.setDouble(1, cost);
            ps.setString(2, title);
            ps.executeUpdate();
            conn.commit();
            ps.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception. Запрос не выполнен");
        }
    }

    //Метод получения товаров заданного диапазона цен
    public static void presetRangeCosts(double cost1, double cost2) {
        ResultSet rs = null;
        ProductsGen<String> pg = null;
        try {
            ps = conn.prepareStatement("SELECT title,cost FROM products WHERE cost >= ? AND cost <= ?;");
            ps.setDouble(1, cost1);
            ps.setDouble(2, cost2);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.print("Товар: " + rs.getString("title") + " стоимость: ");
                System.out.printf("%.2f", rs.getDouble("cost"));
                System.out.println(" у.е.");
//                pg = new ProductsGen<>(rs.getString("title"));
//                pg.printInfo();
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception. Запрос не выполнен.");
        }
    }
}
