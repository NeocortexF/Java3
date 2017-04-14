package ru.geekbrains.java3.dz.dz1.AnosovAlexey.lesson1;

public class Main {

    public static void main(String[] args) {
        
        ArrayGen<Integer> array1 = new ArrayGen<>(1, 2, 3, 5, 8, 13, 21, 34,  55);
        array1.info();
        array1.interchange(0, 3);
        array1.info();
        
        ArrayGen<String> array2 = new ArrayGen<>("one", "two", "three", "four", "five", "six");
        array2.info();
        array2.interchange(0, 4);
        array2.info();
    }
    
}
