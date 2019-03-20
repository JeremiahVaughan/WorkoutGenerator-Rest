package com.madhax.workoutwidget.controller;

import com.madhax.workoutwidget.model.Exercise;
import com.madhax.workoutwidget.model.Person;
import com.madhax.workoutwidget.service.ExerciseService;
import com.madhax.workoutwidget.service.PersonService;
import com.madhax.workoutwidget.service.WorkoutService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class DashboardControllerTest {

    @Mock
    PersonService personService;
    @Mock
    WorkoutService workoutService;
    @Mock
    ExerciseService exerciseService;

    @InjectMocks
    DashboardController controller;

    MockMvc mockMvc;

    Person person;

    List<Exercise> exercises;

    @BeforeEach
    void setUp() {

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        person = new Person();
        person.setId(1L);
        person.setFirstName("John");
        person.setLastName("Doe");

        Exercise exercise1 = new Exercise();
        exercise1.setId(1L);
        exercise1.setName("Dumbell Bench");
        exercise1.setPerson(person);

        Exercise exercise2 = new Exercise();
        exercise2.setId(2L);
        exercise2.setName("Seated Rows");
        exercise2.setPerson(person);

        exercises = Arrays.asList(exercise1, exercise2);

    }

    @Test
    void showDashboard() throws Exception {

        when(personService.getById(anyLong())).thenReturn(person);
        when(exerciseService.getAllByPersonId(anyLong())).thenReturn(exercises);

        mockMvc.perform(get("/dashboard/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("dashboard"))
                .andExpect(model().attributeExists("person"))
                .andExpect(model().attributeExists("exercises"));

        verify(personService, times(1)).getById(anyLong());
        verify(exerciseService, times(1)).getAllByPersonId(anyLong());
    }
}