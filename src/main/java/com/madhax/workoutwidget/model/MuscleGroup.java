package com.madhax.workoutwidget.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.Set;

@Entity
public class MuscleGroup extends BaseEntity {

    private String name;
    private String description;
    private Date lastWorkedOut;

    @ManyToMany
    @JoinTable(
            name = "Exercise_MuscleGroup",
            joinColumns = @JoinColumn(name = "muscleGroup_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id"))
    private Set<Exercise> exercises;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLastWorkedOut() {
        return lastWorkedOut;
    }

    public void setLastWorkedOut(Date lastWorkedOut) {
        this.lastWorkedOut = lastWorkedOut;
    }

    public Set<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(Set<Exercise> exercises) {
        this.exercises = exercises;
    }
}
