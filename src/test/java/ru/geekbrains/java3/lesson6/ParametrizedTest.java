package ru.geekbrains.java3.lesson6;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import ru.geekbrains.java3.lesson6.testing.Calculator;


import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ParametrizedTest {
    private Calculator calc;

    private int x1;
    private int x2;
    private int res;

    @Parameters
    public static Collection abracadabra() {
        return Arrays.asList(
                new Object[][]{
                        {2, 5, 7},
                        {3, 3, 6},
                        {1, 1, 2},
                        {5, 5, 10}
                }
        );
    }

    public ParametrizedTest(int x1, int x2, int res) {
        this.x1 = x1;
        this.x2 = x2;
        this.res = res;
    }

    @After
    public void tearDown() throws Exception {
        calc = null;
    }

    @Before
    public void init() {
        System.out.println("init calc");
        calc = new Calculator();
    }

    @Test
    public void paramAddingTest() {
        Assert.assertEquals(res, calc.add(x1, x2));
    }
}
