package ru.geekbrains.java3.dz.dz6.dmitrygusev;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Дмитрий on 01.05.2017.
 * Домашка 6. Задача 3. Создать небольшую БД (таблица: студенты; поля: id, фамилия, балл).
 * Написать тесты для проверки того, что при работе с базой корректно добавляются, обновляются и читаются записи.
 * Следует учесть что в базе есть заранее добавленные записи,
 * и после проведения тестов эти записи не должны быть удалены/именены/добавлены
 */
class SQLHandler {
    private Connection connection;

    SQLHandler(String name) {
        try {
            connect(name);
            System.out.println("соединяемся с БД");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void connect(String dbName) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);
    }

    void addRow(String name, float overall) throws SQLException {
        Statement statement = connection.createStatement();
        boolean status = statement.execute(
                "INSERT INTO students (name, overall) VALUES (\'" + name + "\', " + overall + ")"
        );
    }

    void deleteRow(int id) throws SQLException {
        Statement statement = connection.createStatement();
        boolean status = statement.execute(
                "DELETE FROM students WHERE id = " + id
        );
    }

    <T> ArrayList<String> getData(String column, T data) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(
                "select * " +
                        "from \"students\" " +
                        "where " + column + " = \"" + data + "\" "
        );
        ArrayList<String> result = new ArrayList<>();
        walkToResultSet(rs, result);
        if (result.size() == 0)
            throw new NullPointerException("Указанной записи в БД не найдено!");
        return result;
    }

    ArrayList<String> getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(
                "SELECT * FROM students"
        );
        ArrayList<String> result = new ArrayList<>();
        walkToResultSet(rs, result);
        return result;
    }

    int getSizeDB() throws SQLException {
        int count = 0;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(
                "SELECT id FROM students"
        );
        while (rs.next()) {
            count++;
        }
        return count;
    }

    void updateName(int id, String name) throws SQLException {
        Statement statement = connection.createStatement();
        boolean status = statement.execute(
                "UPDATE students SET name = \'" + name + "\' WHERE id = " + id
        );
    }

    void updateBall(int id, float ball) throws SQLException {
        Statement statement = connection.createStatement();
        boolean status = statement.execute(
                "UPDATE students SET overall = " + ball + " WHERE id = " + id
        );
    }

    void updateId(int id, int newId) throws SQLException {
        Statement statement = connection.createStatement();
        boolean status = statement.execute(
                "UPDATE students SET id = " + newId + " WHERE id = " + id
        );
    }

    private void walkToResultSet(ResultSet rs, ArrayList<String> result) throws SQLException {
        while (rs.next()) {
            int id = rs.getInt(1);
            String nam = rs.getString(2);
            float ball = rs.getFloat(3);
            result.add(id + ": " + nam + ", ball: " + ball);
        }
    }
}
