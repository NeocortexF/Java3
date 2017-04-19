

package ru.geekbrains.java3.dz.dz2.TintulAnton;

import java.sql.*;
import java.util.Scanner;

public class MainClass {
    public static String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    public static String user = "postgres";
    public static String password = "postgres";

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(dbUrl, user, password);
             Statement stmt = connection.createStatement();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO goods (id, prodid, tittle, cost) VALUES (?, ?, ?, ?)")) {

            stmt.execute("DELETE FROM goods");
            connection.setAutoCommit(false);

            for (int i = 1; i <= 10000; i++) {
                ps.setInt(1, 123455 + i);
                ps.setInt(2, i);
                ps.setString(3, "G" + i);
                ps.setInt(4, i * 10);
                ps.executeUpdate();
            }

            String command = scan.nextLine();

            String tittle;

            if(command.startsWith("/цена")){

                tittle = command.replace("/цена ", "");

                ResultSet rs = stmt.executeQuery("SELECT cost FROM goods WHERE tittle = " + "'" + tittle + "'");
                while (rs.next()) {
                    System.out.print(rs.getInt("cost") + "\n");
                }

            }
            if(command.startsWith("/сменитьцену")){

                String[] arr = command.split(" ");
                tittle = arr[1];
                int newCost = Integer.parseInt(arr[2]);

                stmt.execute("UPDATE goods SET cost = " + "'" + newCost + "'" + " WHERE tittle = " + "'" + tittle + "'");

            }
            if(command.startsWith("/товарыпоцене")){

                String[] arr = command.split(" ");
                int firstBorder = Integer.parseInt(arr[1]);
                int secondBorder = Integer.parseInt(arr[2]);

                ResultSet rs = stmt.executeQuery("SELECT tittle FROM goods WHERE (cost >= " + "'" + firstBorder + "'" + ") AND (cost <= " + "'" + secondBorder + "' )");
                while (rs.next()) {
                    System.out.print(rs.getString("tittle") + "\n");
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
