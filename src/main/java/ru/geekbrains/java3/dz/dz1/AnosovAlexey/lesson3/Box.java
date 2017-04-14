package ru.geekbrains.java3.dz.dz1.AnosovAlexey.lesson3;

import java.util.ArrayList;

public class Box <F extends Fruit> {
    private static int count = 0;
    
    private int number = 0;
    private ArrayList<F> content = new ArrayList<>();
    private int quantity = 0;
    
    public Box() {
        count++;
        number = count;
    }
    public Box(F ... fruits) {
        add(fruits);
        count++;
        number = count;
    }
    public Box(Box<F> box){
        addBox(box);
        count++;
        number = count;
    }
    
    public ArrayList<F> getContent() {
        return content;
    }
    
    public void add(F ... fruits) {
        for (F f:fruits) {
            content.add(f);
            quantity++;
        }
    }
    
    public void addBox(Box<F> box) {
        for (F f: box.getContent()) {
            content.add(f);
            quantity++;
        }
        box.getContent().clear(); // после пересыпания в box будет пусто
    }
    
    public float getWeight() {
        return content.get(1).weight*content.size(); // ПОДСКАЖИТЕ, КАК С ДАННОМ СЛУЧАЕ ЛУЧШЕ ПЕРЕДАТЬ ВЕС?
    }
    
    public boolean compare(Box <? extends Fruit> box) {
        return getWeight() == box.getWeight();
    }
    
    public void info() {
        System.out.println("В " + number + " коробке " + quantity 
                + " шт. фруктов, ее вес " + getWeight());
    }
    
}
