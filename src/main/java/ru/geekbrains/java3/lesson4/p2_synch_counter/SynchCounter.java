package ru.geekbrains.java3.lesson4.p2_synch_counter;


public class SynchCounter {
    int c;

    public int value() { return c; }

    public SynchCounter() {
        c = 0;
    }

    public synchronized void inc() {
        c++;
    }

    public synchronized void dec() {
        c--;
    }
}
