package ru.geekbrains.java3.dz.dz1.TintulAnton;

/**
 * Created by 1 on 12.04.2017.
 */
import java.util.ArrayList;

public class Box <E extends Fruit> {

    private ArrayList<E> arrayList = new ArrayList<E>();
    float weightOfFruit;

    public void fillTheBox(E... elements) { for (int i = 0; i < elements.length; i++) arrayList.add(elements[i]); }

    public void setWeightOfFruit(float weightOfFruit) { this.weightOfFruit = weightOfFruit; }

    public float getWeight(){ return arrayList.size() * weightOfFruit; }

    public boolean compare(Box box){
        return getWeight() == box.getWeight();
    }

    public void changeTheBox(Box<E> box){
        for (int i = 0; i < arrayList.size(); i++) {
            box.fillTheBox(arrayList.get(i));
        }
    }

    public void printArrayList(){
        for (int i = 0; i < arrayList.size(); i++) System.out.println(arrayList.get(i));
    }
}
