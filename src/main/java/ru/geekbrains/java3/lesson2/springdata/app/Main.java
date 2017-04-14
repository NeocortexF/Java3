package ru.geekbrains.java3.lesson2.springdata.app;


import org.springframework.context.support.GenericXmlApplicationContext;
import ru.geekbrains.java3.lesson2.springdata.entities.Contact;
import ru.geekbrains.java3.lesson2.springdata.service.ContactService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring-config.xml");
        ctx.refresh();

        ContactService service = ctx.getBean("jpaContactService", ContactService.class);

        service.save(new Contact(6L,"con1", "co1"));
        service.save(new Contact(7L,"con2", "co2"));
        service.save(new Contact(8L, "con3", "co3"));




        List<Contact> contacts = service.findAll();
        printAll(contacts);

        contacts = service.findByFirstName("con1");
        printAll(contacts);

        contacts = service.findByFirstNameAndLastName("con2", "co2");
        printAll(contacts);
    }

    private static void printAll(List<Contact> contacts) {
        System.out.println("printAll: ");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}
