package ru.geekbrains.java3.dz.dz6.Alexey_Pavlovich;

import java.sql.*;

public class DBWork {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "123";

    public static Connection createConnection() throws SQLException {
        registerDriver();
        return DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
    }

    public static int addRecord(Connection connection, int id, String name, int mark) throws SQLException {
        String insertQuery = "INSERT INTO students (id, name, mark) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setInt(3, mark);

        preparedStatement.execute();
        return preparedStatement.getUpdateCount();
    }

    public static ResultSet readRecord(Connection connection, int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM students WHERE id = ?");
        ps.setInt(1, id);
        return ps.executeQuery();
    }

    public static int updateRecord(Connection connection, int id, int mark) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("UPDATE students SET mark = ? WHERE id = ?");
        ps.setInt(1, mark);
        ps.setInt(2, id);
        ps.executeUpdate();
        return ps.getUpdateCount();
    }

    private static void registerDriver(){
        try{
            DriverManager.registerDriver(new org.postgresql.Driver());
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void loadTestData(Connection connection, Statement statement) throws SQLException {
        statement.execute("DELETE FROM students");

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS students " +
                "(id INT NOT NULL primary key, " +
                "name varchar(200), " +
                "mark INT)"
        );

        String insertQuery = "INSERT INTO students (id, name, mark) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        for (int i = 1; i < 10; i++) {
            preparedStatement.setInt(1, i);
            preparedStatement.setString(2, "Ivan");
            preparedStatement.setInt(3, 5);
            preparedStatement.addBatch();
        }

        preparedStatement.executeBatch();
    }
}
