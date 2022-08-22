package com.cinema.project.controller;

import com.cinema.project.entities.Person;
import com.cinema.project.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class PersonController {
    PersonServiceImpl personService;

    @Autowired
    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public List<Person> getPersons(){
        return personService.getAllPersons();
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable long id){
        return personService.getPerson(id);
    }

    @PostMapping("/person")
    public Person savePerson(@RequestBody Person person){
        personService.saveOrUpdatePerson(person);
        return person;
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable long id){
        personService.deletePerson(id);
    }
}
