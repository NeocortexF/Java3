package ru.geekbrains.java3.dz.dz6.shurukhin;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class shurukhinDZ6MainTest2 {
    private Object arrInput;
    private Object resExpected;

    public shurukhinDZ6MainTest2(Object arrInput, Object resExpected) {
        this.arrInput = arrInput;
        this.resExpected = resExpected;
    }

    @Parameters
    public static Iterable<Object[]> cutAfterFourParams() {
        return Arrays.asList(new Object[][]{
                {new Integer[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, true},
                {new Integer[]{1, 2, 2, 3, 9, 3, 8, 1, 7}, false},
                {new Integer[]{1, 2}, false},
                {new Integer[]{1, 4, 4, 4, 4, 4, 4, 4, 4}, true}
        });
    }

    @Test
    public void isFoursAndOnes() throws Exception {
        Assert.assertEquals(resExpected, shurukhinDZ6Main.isFoursAndOnes((Integer[]) arrInput));
    }

}