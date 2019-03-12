package com.madhax.workoutwidget.service;

import com.madhax.workoutwidget.model.Exercise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExerciseServiceTest {

    @Mock
    ExerciseService exerciseService;

    Exercise exercise1;
    Exercise exercise2;

    List<Exercise> exercises;

    @BeforeEach
    void setUp() {

        exercise1 = new Exercise();
        exercise1.setId(1L);
        exercise1.setName("Dumbell Bench");

        exercise2 = new Exercise();
        exercise2.setId(2L);
        exercise2.setName("Seated Rows");

        exercises = Arrays.asList(exercise1, exercise2);
    }

    @Test
    void getAll() {

        when(exerciseService.getAll()).thenReturn(exercises);

        List<Exercise> returnedExercises = exerciseService.getAll();

        assertEquals(2, returnedExercises.size());
        verify(exerciseService, times(1)).getAll();
    }

    @Test
    void getById() {

        when(exerciseService.getById(anyLong())).thenReturn(exercise1);

        Exercise returnedExercise = exerciseService.getById(1L);

        assertEquals("Dumbell Bench", returnedExercise.getName());
        verify(exerciseService, times(1)).getById(anyLong());
    }

    @Test
    void save() {

        when(exerciseService.save(any())).thenReturn(exercise1);

        Exercise savedExercise = exerciseService.save(exercise1);

        assertEquals("Dumbell Bench", savedExercise.getName());
        verify(exerciseService, times(1)).save(any());
    }

    @Test
    void delete() {

        exerciseService.delete(exercise1);
        verify(exerciseService, times(1)).delete(any());
    }

    @Test
    void deleteById() {

        exerciseService.deleteById(1L);
        verify(exerciseService, times(1)).deleteById(anyLong());
    }
}