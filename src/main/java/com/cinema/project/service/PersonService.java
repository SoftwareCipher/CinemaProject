package com.cinema.project.service;

import com.cinema.project.entities.Person;
import com.cinema.project.repository.PersonRepository;
import com.cinema.project.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
        return personRepository.save(person);
    }

    @Override
    public Person getPerson(long id) {
        return personRepository.getById(id);
    }

    @Override
    public void deletePerson(long id) {
        personRepository.deleteById(id);
    }
}
