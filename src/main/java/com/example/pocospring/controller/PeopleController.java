package com.example.pocospring.controller;

import com.example.pocospring.model.Person;
import com.example.pocospring.service.PersonService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("save_person")
    public Person savePerson(@Valid @RequestBody Person person) {
        return  personService.savePerson(person);
    }

    @GetMapping("/{email}")   // exm: /api/v1/people/test@gmail.com
    public Person findByEmail(@PathVariable String email) {     //or @PathVariable("email"), name "email" is the same and can use @PathVariable
        return personService.findByEmail(email);
    }

    @PutMapping("/update_person")
    public Person updatePerson(@Valid @RequestBody Person person) {
       return personService.updatePerson(person);
    }

    @DeleteMapping("/delete_student/{email}")
    public void deletePerson(@PathVariable String email) {
        personService.deletePerson(email);
    }

}
