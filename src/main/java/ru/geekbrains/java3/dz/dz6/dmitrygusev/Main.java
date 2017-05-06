package ru.geekbrains.java3.dz.dz6.dmitrygusev;

import org.junit.*;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Дмитрий on 30.04.2017.
 * Домашка 6. Точка входа.
 */
public class Main {
    private static Utilities util;
    private static SQLHandler handler;

    private int[] testArr = {1, 23, -234, 45, 4, 2, 0, 0};
    private int[] matchedArr = {3, 14, 5};

    @BeforeClass
    public static void init() {
        System.out.println("init util");
        util = new Utilities();
        handler = new SQLHandler("java3");
    }

    private ArrayList<String> setList(String data) {
        ArrayList<String> list = new ArrayList<>();
        list.add(data);
        return list;
    }

    @Test
    public void t1test1() {
        Assert.assertArrayEquals(util.getAllAfterLast4(testArr), new int[]{2, 0, 0});
    }

    @Test
    public void t1test2() {
        Assert.assertArrayEquals(util.getAllAfterLast4(new int[]{4, 4, 4, 0, 0}), new int[]{0, 0});
    }

    @Test
    public void t1test3() {
        Assert.assertArrayEquals(util.getAllAfterLast4(new int[]{12, 4, 3, 4, 14, 5}), matchedArr);
    }

    @Test
    public void t1test4() {
        Assert.assertArrayEquals(util.getAllAfterLast4(new int[]{4, 34}), new int[]{34});
    }

    @Test
    public void t2test1() {
        Assert.assertTrue(util.hasOnly4and1(new int[]{4, 1, 4, 4, 4, 1, 4, 4, 4, 4, 4, 1}));
    }

    @Test
    public void t2test2() {
        Assert.assertTrue(util.hasOnly4and1(new int[]{4, 1, 4, 5, 4, 1, 4, 4, 4, 4, 4, 1}));
    }

    @Test
    public void t2test3() {
        Assert.assertTrue(util.hasOnly4and1(new int[]{4, 4, 4}));
    }

    @Test
    public void t2test4() {
        Assert.assertTrue(util.hasOnly4and1(testArr));
    }

    @Test
    public void t3test1() {
        try {
            Assert.assertEquals(handler.getData("id", 2), setList("2: Sidorov Sidor, ball: 3.2"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = NullPointerException.class)
    public void t3test2() {
        try {
            handler.getData("id", 8);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
