package com.example.pocospring.service.impl;

import com.example.pocospring.model.Person;
import com.example.pocospring.repository.InMemoryPersonDAO;
import com.example.pocospring.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor //without it should add constructor
public class InMemoryPersonServiceImpl implements PersonService {

    private final InMemoryPersonDAO repository;

    @Override
    public List<Person> findAllPeople() {
        return repository.findAllPeople();
    }

    @Override
    public Person savePerson(Person person) {
        return repository.savePerson(person);
    }

    @Override
    public Person findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Person updatePerson(Person person) {
        return repository.updatePerson(person);
    }

    @Override
    public void deletePerson(String email) {
        repository.deletePerson(email);
    }
}
