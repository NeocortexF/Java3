package ru.geekbrains.java3.dz.dz6.GoryainovVladimir;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Владимир on 04.05.2017.
 */
public class Task2Test {
    @Test
    public void checkArray1() throws Exception {
        int[] arr = { 1, 4, 1, 4, 4, 1, 4, 1};
        Assert.assertTrue(Task2.checkArray(arr));
    }

    @Test
    public void checkArray2() throws Exception {
        int[] arr = { 1, 1, 1, 1, 1 };
        Assert.assertFalse(Task2.checkArray(arr));
    }

    @Test
    public void checkArray3() throws Exception {
        int[] arr = { 4, 4, 4 };
        Assert.assertFalse(Task2.checkArray(arr));
    }
    @Test
    public void checkArray4() throws Exception {
        int[] arr = { 1, 4, 3, 2, 4, 5, 4, 1};
        Assert.assertFalse(Task2.checkArray(arr));
    }
}