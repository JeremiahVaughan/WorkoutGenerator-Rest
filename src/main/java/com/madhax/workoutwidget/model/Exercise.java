package com.madhax.workoutwidget.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Exercise extends BaseEntity {

    private String name;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ExerciseResult> exerciseResults = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

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

    public List<ExerciseResult> getExerciseResults() {
        return exerciseResults;
    }

    public void setExerciseResults(List<ExerciseResult> exerciseResults) {
        this.exerciseResults = exerciseResults;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
