package com.example.pocospring.service;

import com.example.pocospring.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    public List<Person> findAllPeople() {
        return List.of(
                //new Person("Mike", "Holland", "mike@test.com")
                Person.builder().firstName("Mike").lastName("Holland").email("mike@test.com").build(),
                Person.builder().firstName("Steven").lastName("Combs").email("steven@test.com").build(),
                Person.builder().firstName("Karla").lastName("Pollard").email("karla@test.com").build()
        );
    }
}
