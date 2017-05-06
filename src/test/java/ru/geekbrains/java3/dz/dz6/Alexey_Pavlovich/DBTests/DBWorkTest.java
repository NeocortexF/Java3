package ru.geekbrains.java3.dz.dz6.Alexey_Pavlovich.DBTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.geekbrains.java3.dz.dz6.Alexey_Pavlovich.DBWork;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBWorkTest {

    private Connection connection;
    private Statement statement;

    @Before
    public void initConnection(){
        try {
            connection = DBWork.createConnection();
            statement = connection.createStatement();
            DBWork.loadTestData(connection, statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addRecordTest(){
        try {
            Assert.assertEquals(1, DBWork.addRecord(connection, 11, "Peter", 4));
        } catch (SQLException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void updateRecordTest(){
        try {
            Assert.assertEquals(1, DBWork.updateRecord(connection, 3, 2));
        } catch (SQLException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void readRecordTest(){
        try {
            Assert.assertTrue(DBWork.readRecord(connection, 1).next());
        } catch (SQLException e) {
            Assert.fail(e.getMessage());
        }

    }

    @After
    public void closeConnection(){
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
