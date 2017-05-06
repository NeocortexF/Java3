package ru.geekbrains.java3.dz.dz6.Alexey_Pavlovich.ArrayProcessorTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.geekbrains.java3.dz.dz6.Alexey_Pavlovich.ArrayProcessor;

public class ProcessIntArrayTest {

    private ArrayProcessor arrayProcessor;

    @Before
    public void init(){
        arrayProcessor = new ArrayProcessor();
    }

    @Test
    public void processIntArrayTest1(){
        Integer[] result = arrayProcessor.processIntArray(new Integer[]{1, 2, 4, 3, 6});
        Assert.assertArrayEquals(new Integer[]{3, 6}, result);
    }

    @Test(expected = RuntimeException.class)
    public void processIntArrayTest2(){
        arrayProcessor.processIntArray(new Integer[]{1, 2, 2, 3, 5});
    }

    @Test
    public void processIntArrayTest3(){
        Integer[] result = arrayProcessor.processIntArray(new Integer[]{1, 2, 4, 4, 2, 3, 4, 1, 7});
        Assert.assertArrayEquals(new Integer[]{1, 7}, result);
    }
}
