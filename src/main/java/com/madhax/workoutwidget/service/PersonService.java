package com.madhax.workoutwidget.service;

import com.madhax.workoutwidget.model.Person;
import com.madhax.workoutwidget.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final Logger logger = LoggerFactory.getLogger(PersonService.class);

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAll() {
        return (List) personRepository.findAll();
    }

    public Person getById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    public Person save(Person person) {
        Person savedPerson = personRepository.save(person);
        logger.debug("Saving person with ID: {} name: {} {}", person.getId(), person.getFirstName(), person.getLastName());
        return savedPerson;
    }

    public void delete(Person person) {
        personRepository.delete(person);
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
