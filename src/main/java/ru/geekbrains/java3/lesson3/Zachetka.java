package ru.geekbrains.java3.lesson3;

import java.io.Serializable;

public class Zachetka implements Serializable {
    private String id;

    public Zachetka(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
