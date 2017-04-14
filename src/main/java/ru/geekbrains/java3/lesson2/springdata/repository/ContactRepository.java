package ru.geekbrains.java3.lesson2.springdata.repository;


import org.springframework.data.repository.CrudRepository;
import ru.geekbrains.java3.lesson2.springdata.entities.Contact;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long>{
    List<Contact> findByFirstName(String firstName);
    List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
}
