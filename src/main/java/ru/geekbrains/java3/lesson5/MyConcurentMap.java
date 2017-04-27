package ru.geekbrains.java3.lesson5;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class MyConcurentMap {
    private final ReadWriteLock readWriteLock =  new ReentrantReadWriteLock();
    private final Lock read  = readWriteLock.readLock();
    private final Lock write = readWriteLock.writeLock();


    private Map<String, String> map = new HashMap<String, String>();

    public void set(String key, String value) {
        write.lock();
        try {
            map.put(key, value);
        } finally {
            write.unlock();
        }
    }

    public String get(String key) {
        read.lock();
        try{
            return map.get(key);
        } finally {
            read.unlock();
        }
    }

}
