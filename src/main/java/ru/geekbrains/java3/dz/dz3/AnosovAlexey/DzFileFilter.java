package ru.geekbrains.java3.dz.dz3.AnosovAlexey;

import java.io.File;
import java.io.FilenameFilter;

public class DzFileFilter implements FilenameFilter{
    String filter = "file";

    @Override
    public boolean accept(File dir, String name) {
        return name.contains(filter);
    }
    
}
