package com.madhax.workoutwidget.bootstrap;

import com.madhax.workoutwidget.model.*;
import com.madhax.workoutwidget.service.BodyWeightService;
import com.madhax.workoutwidget.service.ExerciseService;
import com.madhax.workoutwidget.service.PersonService;
import com.madhax.workoutwidget.service.WorkoutService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

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
    public void run(String... args) throws Exception {
        initData();
    }

    public void initData() {

        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");

        BodyWeight bodyWeight = new BodyWeight();
        bodyWeight.setWeight(170);
        bodyWeight.setDate(LocalDate.now());

        person.getBodyWeightHistory().add(bodyWeight);

        Workout workout1 = new Workout();
        workout1.setName("Workout 1");
        workout1.setDate(LocalDate.now());

        Exercise exercise1 = new Exercise();
        exercise1.setName("Dumbell Bench");

        ExerciseResult exerciseResult1 = new ExerciseResult();
        exerciseResult1.setSets(3);
        exerciseResult1.setReps(10);

        exercise1.getExerciseResults().add(exerciseResult1);

        workout1.getExercises().add(exercise1);

        personService.save(person);

    }
}
