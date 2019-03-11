package com.madhax.workoutwidget.service;

import com.madhax.workoutwidget.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(SpringRunner.class)
public class PersonServiceTest {

    @Mock
    PersonService personService;

    Person person;

    @Before
    public void setUp() throws Exception {
        person = new Person();
        person.setId(1L);
        person.setFirstName("John");
        person.setLastName("Doe");
    }

    @Test
    public void getAll() {
    }

    @Test
    public void getById() {
    }

    @Test
    public void save() {

        when(personService.save(any())).thenReturn(person);

        Person savedPerson = personService.save(person);

        assertEquals("John", savedPerson.getFirstName());
        verify(personService, times(1)).save(any());
    }

    @Test
    public void delete() {
    }

    @Test
    public void deleteById() {
    }
}