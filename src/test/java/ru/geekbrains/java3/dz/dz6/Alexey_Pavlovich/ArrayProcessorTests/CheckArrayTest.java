package ru.geekbrains.java3.dz.dz6.Alexey_Pavlovich.ArrayProcessorTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.geekbrains.java3.dz.dz6.Alexey_Pavlovich.ArrayProcessor;

public class CheckArrayTest {

    private ArrayProcessor arrayProcessor;

    @Before
    public void init(){
        arrayProcessor = new ArrayProcessor();
    }

    @Test
    public void checkArrayTest1(){
        Assert.assertFalse(arrayProcessor.checkArray(new Integer[]{1, 2, 4, 5}));
    }

    @Test
    public void checkArrayTest2(){
        Assert.assertTrue(arrayProcessor.checkArray(new Integer[]{1, 4, 4, 1}));
    }

    @Test
    public void checkArrayTest3(){
        Assert.assertFalse(arrayProcessor.checkArray(new Integer[]{1, 1, 1, 1,}));
    }
}
