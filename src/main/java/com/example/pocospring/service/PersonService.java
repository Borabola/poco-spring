package com.example.pocospring.service;

import com.example.pocospring.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {
    List<Person> findAllPeople();

    Person savePerson(Person person);

    Person findByEmail(String email);

    Person updatePerson (Person person);

    void deletePerson(String email);
}
