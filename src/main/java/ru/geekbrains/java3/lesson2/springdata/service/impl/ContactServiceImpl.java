package ru.geekbrains.java3.lesson2.springdata.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.java3.lesson2.springdata.entities.Contact;
import ru.geekbrains.java3.lesson2.springdata.service.ContactService;
import ru.geekbrains.java3.lesson2.springdata.repository.ContactRepository;

import java.util.List;

@Service("jpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> findAll() {
        return Lists.newArrayList(contactRepository.findAll());
    }

    public List<Contact> findByFirstName(String firstName) {
        return contactRepository.findByFirstName(firstName);
    }

    public List<Contact> findByFirstNameAndLastName(String firstName, String lastName) {
        return contactRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public void save(Contact contact) {
        contactRepository.save(contact);
    }

}
