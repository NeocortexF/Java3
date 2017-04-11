package ru.geekbrains.java3.lesson1;

import java.util.Arrays;

/**
 * Created by Home-pc on 10.04.2017.
 */
public class MasConteiner<E extends Number> {
    private E[] mas;

    public MasConteiner(E... mas) {
        this.mas = mas;
    }

    public double avg() {
        double sum = 0.0;
        for (E item : mas) {
            sum += item.doubleValue();
        }
        return sum / mas.length;
    }

    public  boolean equalsAvg(MasConteiner<? extends Number> masConteiner) {
        return avg() == masConteiner.avg();
    }

    public void info() {
        System.out.println(Arrays.toString(mas));
    }

    public E[] getMas() {
//        return new E[5];    // так не работает
        return mas;
    }
}
