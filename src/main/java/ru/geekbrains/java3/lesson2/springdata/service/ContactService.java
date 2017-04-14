package ru.geekbrains.java3.lesson2.springdata.service;


import ru.geekbrains.java3.lesson2.springdata.entities.Contact;

import java.util.List;

public interface ContactService  {

    List<Contact> findAll();
    List<Contact> findByFirstName(String firstName);
    List<Contact> findByFirstNameAndLastName(String firstName, String lastName);

    void save(Contact contact);
}
