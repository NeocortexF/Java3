package ru.geekbrains.java3.dz.dz1.shurukhin;

import java.util.*;

/**
 * ДЗ1 Java3
 * 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого
 * ссылочного типа);
 * 2. Написать метод, который преобразует массив в ArrayList;
 * 3. Большая задача:
 * Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
 * Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта,
 * поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 * Для хранения фруктов внутри коробки можете использовать ArrayList;
 * Сделать метод getWeight() который высчитывает вес коробки, зная кол-во фруктов и вес
 * одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
 * Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку
 * с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в
 * противной случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
 * Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку
 * (помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
 * соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты,
 * которые были в этой коробке;
 * Ну и не забываем про метод добавления фрукта в коробку;
 */
class Main {
    public static void main(String[] args) {
        //Задание 1
        Integer[] arrInt = {1, 2, 12, 5434, -7, 143};                  //пока что не умеем работать с примитивами -_-
        String[] arrStr = {"one", "two", "three", "four", "five"};
        ArrayStaticClass.swapArrElements(arrInt, 1, 4);
        ArrayStaticClass.swapArrElements(arrStr, 3, 0);
        System.out.println(Arrays.toString(arrInt));
        System.out.println(Arrays.toString(arrStr));

        System.out.println();

        //Задание 2
        System.out.println(ArrayStaticClass.convertArrToList(arrInt));

        //Задание 3
        BoxOfFruits<Apple> boxOfApples1 = new BoxOfFruits<>(3, new Apple());
        System.out.println(boxOfApples1.getWeight());
        
        BoxOfFruits<Orange> boxOfOranges1 = new BoxOfFruits<>(2, new Orange());
        System.out.println(boxOfOranges1.getWeight());

        System.out.println(boxOfOranges1.compareTo(boxOfApples1));              //Сравниваем вес ящика с апельсинами с весом ящика с яблоками

        BoxOfFruits<Orange> boxOfOranges2 = new BoxOfFruits<>(4, new Orange());
        // boxOfOranges2.moveTo(boxOfApples1);      //переложить апельсины в ящик с яблоками нельзя
        boxOfOranges2.moveTo(boxOfOranges1);
    }
}
