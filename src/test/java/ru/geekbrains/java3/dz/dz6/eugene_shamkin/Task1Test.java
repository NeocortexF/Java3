package ru.geekbrains.java3.dz.dz6.eugene_shamkin;

import org.junit.Assert;
import org.junit.Test;

/**
 * Geekbrains.ru
 * Course name: Java 3
 * Homework 6 performed by Eugene Shamkin, May 4, 2017
 */


public class Task1Test {

    @Test
    public void getArray() throws Exception {
        Task1 task = new Task1();
        int[] expected = new int[] {5, 6};
        int[] givenArray = new int[] {1, 2, 3, 4, 5, 6};
        Assert.assertArrayEquals(expected, task.getArray(givenArray));
    }

}