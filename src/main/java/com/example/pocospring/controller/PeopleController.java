package com.example.pocospring.controller;

import com.example.pocospring.exception.PersonNotFoundException;
import com.example.pocospring.model.Person;
import com.example.pocospring.service.PersonService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @GetMapping("/{email}")   // exm: /api/v1/people/test@gmail.com
    public Optional<Person> findByEmail(@PathVariable String email) throws PersonNotFoundException {     //or @PathVariable("email"), name "email" is the same and can use @PathVariable
        //return personService.findByEmail(email) ;
        Optional<Person> person = Optional.ofNullable(personService.findByEmail(email));
        System.out.println("find person " + person.isPresent());
        if (person.isPresent()) {
            return person;
        }
//        else {
//            throw new PersonNotFoundException("This person hasn't found");
//        }
        throw new PersonNotFoundException("This person hasn't found");

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
