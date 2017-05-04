package ru.geekbrains.java3.dz.dz6.eugene_shamkin;

import org.junit.Assert;
import org.junit.Test;

public class Task2Test {
    int[] arrayWith1 = new int[] {5, 6, 1, 2, 7};
    int[] arrayWith4and1 = new int[] {1, 2, 3, 4, 5, 6};
    int[] arrayWithout4and1 = new int[] {2, 3, 5, 6, 7, 2};
    Task2 task2 = new Task2();

    @Test
    public void isArrayContainsOnly4and1() throws Exception {
        Assert.assertTrue(task2.isArrayContainsOnly4and1(arrayWith4and1));
    }

    @Test
    public void isArrayContains1() throws Exception {
        Assert.assertTrue(task2.isArrayContainsOnly4and1(arrayWith1));
    }

    @Test
    public void isArrayWithout4and1() throws Exception {
        Assert.assertFalse(task2.isArrayContainsOnly4and1(arrayWithout4and1));
    }


}