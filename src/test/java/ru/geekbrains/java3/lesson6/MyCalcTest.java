package ru.geekbrains.java3.lesson6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.geekbrains.java3.lesson6.testing.Calculator;
import ru.geekbrains.java3.lesson6.testing.MyCalc;

public class MyCalcTest {
    private static MyCalc mycalc;

    @BeforeClass
    public static void initTest() {
        mycalc = new MyCalc();
        System.out.println("init suite");
    }

    @Test
    public void testAdd() {
        Assert.assertEquals(6, mycalc.add(3, 3));
    }

    @Test
    public void testSub() {
        Assert.assertEquals(6, mycalc.sub(9, 3));
    }

    @Test
    public void testDiv() {
        Assert.assertEquals(3, mycalc.div(9, 3));
    }

    @Test
    public void testMul() {
        Assert.assertEquals(27, mycalc.mul(9, 3));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivBy0() {
        mycalc.div(10, 0);
    }

    @Test(timeout = 2200)
    public void testVeryFastMethod() {
        mycalc.add(10, 10);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
