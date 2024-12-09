package com.example.pocospring.controller;

import com.example.pocospring.model.Person;
import com.example.pocospring.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
//@RequiredArgsConstructor // + @NonNull
@AllArgsConstructor  //if not from lombok lib - need to add constructor
public class PeopleController {
    //@Autowired //old, @RequiredArgsConstructor is better
    private final PersonService personService; //= new PersonService();   //temp, should be replaced by Spring logic

    //@NonNull
    @GetMapping
    public List<Person> findAllPeople() {
        //todo
        return personService.findAllPeople();
    }
}
