package com.madhax.workoutwidget.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Exercise extends BaseEntity {

    private String name;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exercise")
    private List<ExerciseDetails> exerciseDetails = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToMany(mappedBy = "exercises")
    private Set<MuscleGroup> muscleGroups;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public List<ExerciseDetails> getExerciseDetails() {
        return exerciseDetails;
    }

    public void setExerciseDetails(List<ExerciseDetails> exerciseDetails) {
        this.exerciseDetails = exerciseDetails;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
