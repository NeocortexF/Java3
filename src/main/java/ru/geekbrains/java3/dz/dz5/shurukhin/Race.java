package ru.geekbrains.java3.dz.dz5.shurukhin;

import java.util.ArrayList;
import java.util.Arrays;

class Race {
    private ArrayList<Stage> stages;

    ArrayList<Stage> getStages() {
        return stages;
    }

    Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}
