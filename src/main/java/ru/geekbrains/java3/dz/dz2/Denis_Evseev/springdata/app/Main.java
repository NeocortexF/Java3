package ru.geekbrains.java3.dz.dz2.Denis_Evseev.springdata.app;


import org.springframework.context.support.GenericXmlApplicationContext;
import ru.geekbrains.java3.dz.dz2.Denis_Evseev.springdata.entities.Product;
import ru.geekbrains.java3.dz.dz2.Denis_Evseev.springdata.service.ProductService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args){

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring-config.xml");
        ctx.refresh();

        ProductService service = ctx.getBean("jpaContactService", ProductService.class);

        service.deleteAll();


        // айдишники не смотря на чистку создаются все новые и новые если следовать условию от так и long закончится может..и он заканчивается.
        //подскажите как это починить?
        for (int i = 1; i <101 ; i++) {
            service.save(new Product((long)i,"prod"+i, "pr title"+i,(long)i*10));
        }

        List<Product> products = service.findAll();
        printAll(products);

        System.out.println("/с - узнать цену товара по eго имени /pbyc - изменить цену товара (*имя* *новая цена*)" +
                "/newc - Вывести товары в заданном ценовом диапазоне *cost1* *cost2*.");
        while (true) {
            try {
                    consoleCommander(service);

            } catch (Exception e) {
                System.out.println("Неверная команда!");
                e.printStackTrace();
            }
        }


    }

    private static void consoleCommander(ProductService service) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        if (command.startsWith("/c ")) { //продукты не повторяются так что больше 1го в листе их не должно юыть
            System.out.println("cost is: " + service.findByprodid(command.split(" ")[1]).get(0).getCost());
        }
        if (command.startsWith("/pbyc ")) {  //TODO странно работает разобраться
            printAll(service.findBycostBetween(Long.parseLong(command.split(" ")[1]),
                    Long.parseLong(command.split(" ")[2])));
        }
        if (command.startsWith("/newc ")) {
            service.setCostByProdid(command.split(" ")[1], Long.parseLong(command.split(" ")[2]));
        }

    }

    private static void printAll(List<Product> products) {
        System.out.println("printAll: ");
            for (Product product : products)
                System.out.println(product);
    }
}
