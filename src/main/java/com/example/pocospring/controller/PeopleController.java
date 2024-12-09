package com.example.pocospring.controller;

import com.example.pocospring.model.Person;
import com.example.pocospring.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PeopleController {

    private PersonService personService = new PersonService();   //temp, should be replaced by Spring logic

    @GetMapping
    public List<Person> findAllPeople() {
        //todo
        return personService.findAllPeople();
    }
}
