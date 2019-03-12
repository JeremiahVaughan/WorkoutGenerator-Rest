package com.madhax.workoutwidget.service;

import com.madhax.workoutwidget.model.BodyWeight;
import com.madhax.workoutwidget.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BodyWeightServiceTest {

    @Mock
    BodyWeightService bodyWeightService;

    Person person;
    BodyWeight bodyWeight1;
    BodyWeight bodyWeight2;

    List<BodyWeight> bodyWeights;

    @BeforeEach
    void setUp() {

        person = new Person();
        person.setId(1L);
        person.setFirstName("John");
        person.setLastName("Doe");

        bodyWeight1 = new BodyWeight();
        bodyWeight1.setId(1L);
        bodyWeight1.setWeight(200);
        bodyWeight1.setDate(LocalDate.parse("2019-01-03"));
        bodyWeight1.setPerson(person);

        bodyWeight2 = new BodyWeight();
        bodyWeight2.setId(2L);
        bodyWeight2.setWeight(175);
        bodyWeight2.setDate(LocalDate.parse("2019-03-12"));
        bodyWeight2.setPerson(person);

        bodyWeights = Arrays.asList(bodyWeight1, bodyWeight2);

        person.getBodyWeightHistory().addAll(bodyWeights);
    }

    @Test
    void getAll() {

        when(bodyWeightService.getAll()).thenReturn(bodyWeights);

        List returnedBWList = bodyWeightService.getAll();

        assertEquals(2, returnedBWList.size());
        verify(bodyWeightService, times(1)).getAll();

    }

    @Test
    void getById() {

        when(bodyWeightService.getById(anyLong())).thenReturn(bodyWeight1);

        BodyWeight returnedBodyWeight = bodyWeightService.getById(1L);

        assertEquals(200, (int) returnedBodyWeight.getWeight());
        verify(bodyWeightService, times(1)).getById(anyLong());
    }

    @Test
    void save() {

        when(bodyWeightService.save(any())).thenReturn(bodyWeight1);

        BodyWeight savedBodyWeight = bodyWeightService.save(bodyWeight1);

        assertEquals(200, (int) savedBodyWeight.getWeight());
        verify(bodyWeightService, times(1)).save(any());
    }

    @Test
    void delete() {

        bodyWeightService.delete(bodyWeight1);
        verify(bodyWeightService, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        bodyWeightService.deleteById(1L);
        verify(bodyWeightService, times(1)).deleteById(anyLong());
    }
}