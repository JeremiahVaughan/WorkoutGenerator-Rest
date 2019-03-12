package com.madhax.workoutwidget.service;

import com.madhax.workoutwidget.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    PersonService personService;

    Person person1;
    Person person2;

    List<Person> people;

    @BeforeEach
    public void setUp() throws Exception {

        person1 = new Person();
        person1.setId(1L);
        person1.setFirstName("John");
        person1.setLastName("Doe");

        person2 = new Person();
        person2.setId(2L);
        person2.setFirstName("Anna");
        person2.setLastName("Smith");

        people = Arrays.asList(person1, person2);
    }

    @Test
    public void getAll() {

        when(personService.getAll()).thenReturn(people);

        List<Person> returnedPeople = personService.getAll();

        assertEquals(2, returnedPeople.size());
        verify(personService, times(1)).getAll();
    }

    @Test
    public void getById() {

        when(personService.getById(anyLong())).thenReturn(person1);

        Person returnedPerson = personService.getById(1L);

        assertEquals("John", returnedPerson.getFirstName());
        verify(personService, times(1)).getById(anyLong());
    }

    @Test
    public void save() {

        when(personService.save(any())).thenReturn(person1);

        Person savedPerson = personService.save(person1);

        assertEquals("John", savedPerson.getFirstName());
        verify(personService, times(1)).save(any());
    }

    @Test
    public void delete() {

        personService.delete(person1);
        verify(personService, times(1)).delete(any());
    }

    @Test
    public void deleteById() {

        personService.deleteById(1L);
        verify(personService, times(1)).deleteById(anyLong());
    }
}