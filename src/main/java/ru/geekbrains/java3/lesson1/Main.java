package ru.geekbrains.java3.lesson1;

/**
 * Created by Home-pc on 10.04.2017.
 */
public class Main {
    public static void main(String[] args) {
//        Box box1 = new Box("string___");
//        Box box2 = new Box(3);
//
//        box1.info();
//        box2.info();

        //...
        //...

//        int x = 10;
//        x += (Integer) box2.getObj();
//        System.out.println(x);
//        x = 10;
//        x += (Integer) box1.getObj();
//        System.out.println(x);

//        BoxInt box3 = new BoxInt(3);
//        int x = 10;
//        x += box3.getObj();
//        System.out.println(x);

//        BoxInt box4 = new BoxInt("hsvkdf");   // так нельзя сделать
//        x = 10;
//        x += box4.getObj();
//        System.out.println(x);

//        BoxGen<Integer> integerBoxGen = new BoxGen<>(5);
//        integerBoxGen.info();
//        int x = 10;
//        x += integerBoxGen.getObj();
//        System.out.println(x);
//
//        BoxGen<String> stringBoxGen = new BoxGen<>("hfgjh");
//        stringBoxGen.info();
//
//        ArrayList<Integer> integerList;
//        HashMap<Integer, String> integerStringHashMap;

//        BoxNumber<Long> longBoxNumber = new BoxNumber<>(5L);
//        longBoxNumber.info();


        MasConteiner<Integer> masConteiner1 = new MasConteiner(1, 2, 3, 4, 2, 4, 3, 5, 1, 8, 5, 6, 6);
        masConteiner1.info();
        System.out.println(masConteiner1.avg());

        MasConteiner<Integer> masConteiner2 = new MasConteiner(1, 2, 3, 4, 6, 4, 3, 5, 1, 8, 5, 6, 6);
        masConteiner2.info();
        System.out.println(masConteiner2.avg());

        System.out.println(masConteiner1.equalsAvg(masConteiner2));

        MasConteiner<Byte> masConteiner3 = new MasConteiner(1, 2, 3, 4, 2, 4, 3, 5, 1, 8, 5, 6, 6);
        masConteiner3.info();
        System.out.println(masConteiner3.avg());
        System.out.println(masConteiner1.equalsAvg(masConteiner3));
    }
}






