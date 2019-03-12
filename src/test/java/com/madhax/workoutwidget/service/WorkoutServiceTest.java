package com.madhax.workoutwidget.service;

import com.madhax.workoutwidget.model.Workout;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WorkoutServiceTest {

    @Mock
    WorkoutService workoutService;

    Workout workout1;
    Workout workout2;

    List<Workout> workouts;

    @BeforeEach
    void setUp() {

        workout1 = new Workout();
        workout1.setId(1L);
        workout1.setName("Workout 1");
        workout1.setDate(LocalDate.parse("2019-01-03"));

        workout2 = new Workout();
        workout2.setId(2L);
        workout2.setName("Workout 2");
        workout2.setDate(LocalDate.parse("2019-03-12"));

        workouts = Arrays.asList(workout1, workout2);
    }

    @Test
    void getAll() {

        when(workoutService.getAll()).thenReturn(workouts);

        List<Workout> returnedWorkouts = workoutService.getAll();

        assertEquals(2, returnedWorkouts.size());
        verify(workoutService, times(1)).getAll();
    }

    @Test
    void getById() {

        when(workoutService.getById(anyLong())).thenReturn(workout1);

        Workout returnedWorkout = workoutService.getById(1L);

        assertEquals(1L, (long) returnedWorkout.getId());
        verify(workoutService, times(1)).getById(anyLong());
    }

    @Test
    void save() {

        when(workoutService.save(any())).thenReturn(workout1);

        Workout savedWorkout = workoutService.save(workout1);

        assertEquals(1L, (long) savedWorkout.getId());
        verify(workoutService, times(1)).save(any());
    }

    @Test
    void delete() {

        workoutService.delete(workout1);
        verify(workoutService, times(1)).delete(any());
    }

    @Test
    void deleteById() {

        workoutService.deleteById(1L);
        verify(workoutService, times(1)).deleteById(anyLong());
    }
}