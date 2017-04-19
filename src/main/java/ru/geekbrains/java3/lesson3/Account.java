package ru.geekbrains.java3.lesson3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Account implements Externalizable {
    int id;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.write(id * 123);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = in.read() / 123;
    }
}
