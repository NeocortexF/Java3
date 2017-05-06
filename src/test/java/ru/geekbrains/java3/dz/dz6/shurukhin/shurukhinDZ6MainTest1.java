package ru.geekbrains.java3.dz.dz6.shurukhin;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

@RunWith(value = Parameterized.class)
public class shurukhinDZ6MainTest1 {
    private Object arrInput;
    private Object arrExpected;

    public shurukhinDZ6MainTest1(Object arrInput, Object arrExpected) {
        this.arrInput = arrInput;
        this.arrExpected = arrExpected;
    }

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Parameters
    public static Iterable<Object[]> cutAfterFourParams() {
        return Arrays.asList(new Object[][]{
                {new Integer[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new Integer[]{1, 7}},
                {new Integer[]{1, 2, 2, 3, 4, 3, 8, 1, 7}, new Integer[]{3, 8, 1, 7}},
//                {new Integer[]{1, 2}, RuntimeException.class},
                {new Integer[]{4, 4, 4, 4, 4, 4, 4, 4, 4}, new Integer[0]}
        });
    }

//    @Test
//    public void cutAfterFourPositive() throws Exception {
//        if (arrExpected == RuntimeException.class) {
//            expected.expect(RuntimeException.class);
//            expected.expectMessage("Входной массив не содержит четверок");
//            shurukhinDZ6Main.cutAfterFour((Integer[]) arrInput);
//        } else {
//            Assert.assertArrayEquals((Integer[]) arrExpected, shurukhinDZ6Main.cutAfterFour((Integer[]) arrInput));
//        }
//
//    }

    @Test
    public void cutAfterFourPositive() throws Exception {
        Assert.assertArrayEquals((Integer[]) arrExpected, shurukhinDZ6Main.cutAfterFour((Integer[]) arrInput));
    }

    @Test(expected = RuntimeException.class)
    public void cutAfterFourPositiveException() throws Exception {
        shurukhinDZ6Main.cutAfterFour(new Integer[]{1, 2});
    }
}