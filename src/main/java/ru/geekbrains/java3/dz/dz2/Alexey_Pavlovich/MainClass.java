package ru.geekbrains.java3.dz.dz2.Alexey_Pavlovich;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Math.*;

public class MainClass {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "123";

    private static final String COMMAND_GET_PRODUCT = "/цена";
    private static final String COMMAND_UPDATE_PRICE = "/сменитьцену";
    private static final String COMMAND_GET_PRODUCTS_FOR_RANGE = "/товарыпоцене";
    private static final String COMMAND_EXIT = "exit";

    public static void main(String[] args) {

        registerDriver();

        try (Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
             Statement statement = connection.createStatement();
             Scanner in = new Scanner(System.in)
        ){
            loadTestData(connection, statement);
            System.out.println("Соединение установлено.");

            String command = "";
            while (!command.equals(COMMAND_EXIT)){
                System.out.println("Введите команду (exit для выхода): ");
                command = in.next();
                if (command.startsWith(COMMAND_GET_PRODUCT)){
                    String name = in.next();
                    getProducts(connection, name);
                }else if (command.equals(COMMAND_UPDATE_PRICE)){
                    String name = in.next();
                    int newPrice = in.nextInt();
                    updatePrice(connection, name, newPrice);
                }else if (command.equals(COMMAND_GET_PRODUCTS_FOR_RANGE)){
                    int leftBorder = in.nextInt();
                    int rightBorder = in.nextInt();
                    getProductsForRange(connection, leftBorder, rightBorder);
                }else if(!command.equals(COMMAND_EXIT)){
                    System.out.println("Unknown command!");
                }
            }
        } catch (SQLException | InputMismatchException e) {
            e.printStackTrace();
        }
    }

    private static void registerDriver(){
        try{
            DriverManager.registerDriver(new org.postgresql.Driver());
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void loadTestData(Connection connection, Statement statement) throws SQLException {
        statement.execute("DELETE FROM products");

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS products " +
                "(id INT NOT NULL primary key, " +
                "prodid INT NOT NULL, " +
                "title varchar(200), " +
                "cost INT)"
        );

        String insertQuery = "INSERT INTO products (id, prodid, title, cost) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        for (int i = 0; i < 10000; i++) {
            preparedStatement.setInt(1, i);
            preparedStatement.setInt(2, i);
            preparedStatement.setString(3, "товар_" + i);
            preparedStatement.setInt(4, (int) (random()*10000));
            preparedStatement.addBatch();
        }

        preparedStatement.executeBatch();
    }

    private static void getProducts(Connection connection, String name) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM products WHERE title = ?");
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            System.out.println(rs.getInt("cost"));
        }else {
            System.out.println("Такого товара нет");
        }
    }

    private static void updatePrice(Connection connection, String name, int newPrice) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("UPDATE products SET cost = ? WHERE title = ?");
        ps.setInt(1, newPrice);
        ps.setString(2, name);
        ps.executeUpdate();
    }

    private static void getProductsForRange(Connection connection, int leftBorder, int rightBorder) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM products WHERE cost > ? AND cost < ?");
        ps.setInt(1, leftBorder);
        ps.setInt(2, rightBorder);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("title") + " " + rs.getString("cost"));
        }
    }
}
