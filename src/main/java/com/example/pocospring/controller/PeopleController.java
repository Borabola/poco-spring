package com.example.pocospring.controller;

import com.example.pocospring.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PeopleController {

    @GetMapping
    public List<Person> findAllPeople() {
        return List.of(
                //new Person("Mike", "Holland", "mike@test.com")
                Person.builder().firstName("Mike").lastName("Holland").email("mike@test.com").build(),
                Person.builder().firstName("Steven").lastName("Combs").email("steven@test.com").build(),
                Person.builder().firstName("Karla").lastName("Pollard").email("karla@test.com").build()
        );
    }
}
