package ru.geekbrains.java3.dz.dz6.shurukhin.DB;

import ru.geekbrains.java3.lesson6.logging.Example4Filters;

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Выполняем запросы
 */
class SQLExec {
    private static final Logger logger = Logger.getLogger(Example4Filters.class.getName());

    static List<Map<String, Object>> execute(DbDriver driver, Object... parameters) {
        logger.setLevel(Level.SEVERE);

        try {
            if (parameters.length < 1) throw new IllegalArgumentException("Не указан запрос");
            List<Map<String, Object>> result = new ArrayList<>();

            PreparedStatement stmt = driver.getConn().prepareStatement((String) parameters[0]);

            if (parameters.length > 1) {
                for (int i = 1; i < parameters.length; i++) {
                    if (parameters[i] instanceof Date) {
                        stmt.setTimestamp(i, new Timestamp(((Date) parameters[i]).getTime()));
                    } else if (parameters[i] instanceof Integer) {
                        stmt.setInt(i, (Integer) parameters[i]);
                    } else if (parameters[i] instanceof Long) {
                        stmt.setLong(i, (Long) parameters[i]);
                    } else if (parameters[i] instanceof Double) {
                        stmt.setDouble(i, (Double) parameters[i]);
                    } else if (parameters[i] instanceof Float) {
                        stmt.setFloat(i, (Float) parameters[i]);
                    } else {
                        stmt.setString(i, (String) parameters[i]);
                    }
                }
            }

            logger.log(Level.INFO, stmt.toString());

            if (stmt.execute()) {
                ResultSet rs = stmt.getResultSet();
                ResultSetMetaData rsmd = rs.getMetaData();
                int colcount = rsmd.getColumnCount();

                if (colcount < 1) return Collections.emptyList();

                while (rs.next()) {
                    Map<String, Object> row = new HashMap<>();
                    for (int i = 1; i <= colcount; i++) {
                        row.put(rsmd.getColumnLabel(i), rs.getObject(i));
                    }
                    result.add(row);
                }
                if (!result.isEmpty()) return result;
            } else {
                int count = stmt.getUpdateCount();
                logger.log(Level.INFO, "Запрос успешно выполнен: " + count + " строк изменено");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return Collections.emptyList();
    }

    static void printOutput(DbDriver driver, String... parameters) {
        List<Map<String, Object>> result = execute(driver, parameters);
        if (!result.isEmpty())
            for (int i = 0; i < result.size(); i++) {
                System.out.println("Запись №" + (i + 1) + ":");
                for (String column : result.get(i).keySet()) {
                    System.out.println(column + " = " + result.get(i).get(column));
                }
            }

    }
}
