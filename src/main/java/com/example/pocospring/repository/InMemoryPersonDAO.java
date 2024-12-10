package com.example.pocospring.repository;

import com.example.pocospring.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryPersonDAO  {
    private final List<Person> PEOPLE = new ArrayList<>( );

    public List<Person> findAllPeople() {
        return PEOPLE;
    }


    public Person savePerson(Person person) {
        PEOPLE.add(person);
        return person;
    }

    public Person findByEmail(String email) {
        return PEOPLE.stream()
                .filter(element -> element.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public Person updatePerson(Person person) {
        var personIndex = IntStream.range(0, PEOPLE.size())
                .filter(index -> PEOPLE.get(index).getEmail().equals(person.getEmail()))
                .findFirst()
                .orElse(-1);
        if (personIndex > -1) {
            PEOPLE.set(personIndex, person);
            return person;
        }
        return null;
    }

    public void deletePerson(String email) {
        var person = findByEmail(email);
        if (person != null) {
            PEOPLE.remove(person);
        }
    }
}
