package ru.geekbrains.java3.dz.dz6.shurukhin.DB;

import ru.geekbrains.java3.lesson6.logging.Example4Filters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс соединения с БД
 */
class DbDriver {
    private static final Logger logger = Logger.getLogger(Example4Filters.class.getName());
    private static final String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "postgres"; // наверно нехорошо делать пароль публичным, но пока так
    private Connection conn;

    DbDriver() {
        logger.setLevel(Level.SEVERE);
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            conn = DriverManager.getConnection(dbUrl, user, password);
            if (conn != null) {
                logger.log(Level.INFO,"Подключение к базе данных прошло успешно!\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Connection getConn() {
        return conn;
    }

    void closeConnection() {
        try {
            conn.close();
        } catch (Exception c) {
            System.out.println("Connection Error");
        }
    }
}
