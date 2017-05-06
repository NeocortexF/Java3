package ru.geekbrains.java3.dz.dz6.GoryainovVladimir;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Владимир on 04.05.2017.
 */
public class Task1Test {

    @Test
    public void testNewArray1() throws Exception {
        int[] arr = { 1, 2, 4, 4, 2, 3, 4, 1, 7};
        Assert.assertArrayEquals(new int[] { 1, 7 }, Task1.newArray(arr));
        return;
    }

    @Test
    public void testNewArray2() throws Exception {
        int[] arr = { 5, 6, 4, 8, 1, 4, 8, 9, 2, 1};
        Assert.assertArrayEquals(new int[] { 8, 9, 2, 1 }, Task1.newArray(arr));
    }

    @Test
    public void testNewArray3() throws Exception {
        int[] arr = { 4, 1 };
        Assert.assertArrayEquals(new int[] { 1 }, Task1.newArray(arr));
    }

    @Test (expected = RuntimeException.class)
    public void testNewArray4() throws Exception {
        int[] arr = { 2, 1, 6, 7, 1 };
        Task1.newArray(arr);
    }
}