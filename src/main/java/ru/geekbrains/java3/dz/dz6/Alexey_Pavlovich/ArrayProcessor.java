package ru.geekbrains.java3.dz.dz6.Alexey_Pavlovich;

import java.util.Arrays;

public class ArrayProcessor {

    public Integer[] processIntArray(Integer[] source){

        if (!Arrays.asList(source).contains(4)){
            throw new RuntimeException();
        }

        int startIndex = Arrays.asList(source).lastIndexOf(4) + 1;

        return Arrays.copyOfRange(source, startIndex, source.length);
    }

    public boolean checkArray(Integer[] inputArray){

        if (Arrays.stream(inputArray).allMatch(x -> x == 1 || x == 4)){
            return Arrays.stream(inputArray)
                    .filter(x -> x == 1 || x == 4)
                    .distinct()
                    .count() == 2;
        }

        return false;
    }
}
