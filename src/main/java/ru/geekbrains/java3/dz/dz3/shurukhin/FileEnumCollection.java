package ru.geekbrains.java3.dz.dz3.shurukhin;

import com.sun.istack.internal.Nullable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

/**
 * Коллекция файлов
 */
class FileEnumCollection {
    private Enumeration<FileWorker> files;

    FileEnumCollection(int amount, int length) {
        ArrayList<FileWorker> arrayOfFiles = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            try {
                arrayOfFiles.add(new FileWorker("100bytes" + (i + 1) + ".txt").genRandomFile(length));
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        this.files = Collections.enumeration(arrayOfFiles);
    }

    Enumeration<FileWorker> getFiles() {
        return files;
    }

    @Nullable
    FileWorker joinFiles() {
        FileWorker result = null;
        try {
            if ((result = files.nextElement()) != null)
                while (files.hasMoreElements()) {
                    FileWorker tmp = files.nextElement();
                    result.append(tmp);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    void printJoinedFile() {
        System.out.println(joinFiles().readFileString());
    }

    void deleteAll() {
        while (files.hasMoreElements())
            try {
                files.nextElement().delete();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
