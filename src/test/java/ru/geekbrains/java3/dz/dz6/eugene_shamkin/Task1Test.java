package ru.geekbrains.java3.dz.dz6.eugene_shamkin;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Geekbrains.ru
 * Course name: Java 3
 * Homework 6 performed by Eugene Shamkin, May 4, 2017
 */

@RunWith(Parameterized.class)
public class Task1Test {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {1, 2, 3, 5, 4, 6, 8},
                {4, 4, 3, 0, 4, 0, 7},
                {3, 2, 3, 4, 3, 2, 1},
                {1, 8, 4, 9, 2, 3, 8},
                {1, 2, 3, 5, 0, 0, 8},
        });
    }

    private int[] incomingArray;
    private int[] outcomingArray;

    public Task1Test(int[] incomingArray, int[] outcomingArray) {
        this.incomingArray = incomingArray;
        this.outcomingArray = outcomingArray;
    }

    Task1 task1;

    @Before
    public void init() {
        task1 = new Task1();
    }

    @Test
    public void getArray() throws Exception {

    }

}