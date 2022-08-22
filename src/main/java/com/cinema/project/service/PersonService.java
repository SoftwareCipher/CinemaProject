package com.cinema.project.service;

import com.cinema.project.entities.Pay;
import com.cinema.project.entities.Person;
import com.cinema.project.repository.PersonRepository;
import com.cinema.project.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements PersonServiceImpl {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person saveOrUpdatePerson(Person person) {
         return personRepository.saveAndFlush(person);
    }

    @Override
    public Person getPerson(long id) {
        Person person = null;
        Optional<Person> optionalPay = personRepository.findById(id);
        if(optionalPay.isPresent()){
            person = optionalPay.get();
        }else{
            System.out.println("Error! Person " + id + " not found!");
        }
        return person;
    }

    @Override
    public void deletePerson(long id) {
        personRepository.deleteById(id);
    }
}
