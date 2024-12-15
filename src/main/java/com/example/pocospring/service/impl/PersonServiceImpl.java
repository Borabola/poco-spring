package com.example.pocospring.service.impl;

import com.example.pocospring.model.Person;
import com.example.pocospring.repository.PeopleRepository;
import com.example.pocospring.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class PersonServiceImpl implements PersonService {
    private final PeopleRepository repository;

    @Override
    public List<Person> findAllPeople() {
        return repository.findAll();
    }

    @Override
    public Person savePerson(Person person) {
        return repository.save(person);
    }

    @Override
    public Person findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Person updatePerson(Person person) {
        return repository.save(person);
    }

    @Override
    @Transactional
    public void deletePerson(String email) {
        repository.deleteByEmail(email);
    }
}
