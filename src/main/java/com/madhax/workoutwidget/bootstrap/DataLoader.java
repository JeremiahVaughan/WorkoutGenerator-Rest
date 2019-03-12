package com.madhax.workoutwidget.bootstrap;

import com.madhax.workoutwidget.model.*;
import com.madhax.workoutwidget.service.BodyWeightService;
import com.madhax.workoutwidget.service.ExerciseService;
import com.madhax.workoutwidget.service.PersonService;
import com.madhax.workoutwidget.service.WorkoutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    private final PersonService personService;
    private final BodyWeightService bodyWeightService;
    private final ExerciseService exerciseService;
    private final WorkoutService workoutService;

    public DataLoader(PersonService personService, BodyWeightService bodyWeightService, ExerciseService exerciseService, WorkoutService workoutService) {
        this.personService = personService;
        this.bodyWeightService = bodyWeightService;
        this.exerciseService = exerciseService;
        this.workoutService = workoutService;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    public void initData() {

        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");

        BodyWeight bodyWeight = new BodyWeight();
        bodyWeight.setWeight(170);
        bodyWeight.setDate(LocalDate.now());
        bodyWeight.setPerson(person);

        person.getBodyWeightHistory().add(bodyWeight);

        Workout workout1 = new Workout();
        workout1.setName("Workout 1");
        workout1.setDate(LocalDate.now());
        workout1.setPerson(person);

        Exercise exercise1 = new Exercise();
        exercise1.setName("Dumbell Bench");
        exercise1.setWorkout(workout1);

        ExerciseDetails exerciseDetails1 = new ExerciseDetails();
        exerciseDetails1.setSets(3);
        exerciseDetails1.setReps(10);

        exercise1.getExerciseDetails().add(exerciseDetails1);

        workout1.getExercises().add(exercise1);

        person.getWorkouts().add(workout1);

        logger.debug("Bootstrap: saving person.");
        personService.save(person);

    }
}
