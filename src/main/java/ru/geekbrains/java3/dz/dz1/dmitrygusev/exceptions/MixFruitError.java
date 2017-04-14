package ru.geekbrains.java3.dz.dz1.dmitrygusev.exceptions;

/**
 * Created by Дмитрий on 11.04.2017.
 */
public class MixFruitError extends Throwable {

    public String getMsg() {
        return "Нельзя смешивать фрукты в одной коробке!";
    }
}
