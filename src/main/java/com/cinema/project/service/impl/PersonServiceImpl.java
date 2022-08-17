package com.cinema.project.service.impl;

import com.cinema.project.entities.Person;
import java.util.List;

public interface PersonServiceImpl {
    List<Person> getAllPersons();

    void saveOrUpdatePerson(Person person);

    Person getPerson(long id);

    void deletePerson(long id);
}
