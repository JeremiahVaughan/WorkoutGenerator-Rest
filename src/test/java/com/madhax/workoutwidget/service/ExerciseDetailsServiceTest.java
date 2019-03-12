package com.madhax.workoutwidget.service;

import com.madhax.workoutwidget.model.ExerciseDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExerciseDetailsServiceTest {

    @Mock
    ExerciseDetailsService exerciseDetailsService;

    ExerciseDetails exerciseDetails1;
    ExerciseDetails exerciseDetails2;

    List<ExerciseDetails> exerciseDetails;

    @BeforeEach
    void setUp() {

        exerciseDetails1 = new ExerciseDetails();
        exerciseDetails1.setId(1L);
        exerciseDetails1.setSets(3);
        exerciseDetails1.setReps(10);

        exerciseDetails2 = new ExerciseDetails();
        exerciseDetails2.setMiles(1.0);
        exerciseDetails2.setMinutes(10);
        exerciseDetails2.setSeconds(30);

        exerciseDetails = Arrays.asList(exerciseDetails1, exerciseDetails2);
    }

    @Test
    void getAll() {

        when(exerciseDetailsService.getAll()).thenReturn(exerciseDetails);

        List<ExerciseDetails> returnedDetails = exerciseDetailsService.getAll();

        assertEquals(2, returnedDetails.size());
        verify(exerciseDetailsService, times(1)).getAll();
    }

    @Test
    void getById() {

        when(exerciseDetailsService.getById(anyLong())).thenReturn(exerciseDetails1);

        ExerciseDetails returnedDetails = exerciseDetailsService.getById(1L);

        assertEquals(1L, (long) returnedDetails.getId());
        verify(exerciseDetailsService, times(1)).getById(anyLong());
    }

    @Test
    void save() {

        when(exerciseDetailsService.save(any())).thenReturn(exerciseDetails1);

        ExerciseDetails savedDetails = exerciseDetailsService.save(exerciseDetails1);

        assertEquals(1L, (long) savedDetails.getId());
        verify(exerciseDetailsService, times(1)).save(any());
    }

    @Test
    void delete() {

        exerciseDetailsService.delete(exerciseDetails1);
        verify(exerciseDetailsService, times(1)).delete(any());
    }

    @Test
    void deleteById() {

        exerciseDetailsService.deleteById(1L);
        verify(exerciseDetailsService, times(1)).deleteById(anyLong());
    }
}