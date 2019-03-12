package com.madhax.workoutwidget.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person extends BaseEntity {

    private String firstName;
    private String lastName;
    private Integer heightFeet;
    private Integer heightInches;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<BodyWeight> bodyWeightHistory = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Workout> workouts = new ArrayList<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getHeightFeet() {
        return heightFeet;
    }

    public void setHeightFeet(Integer heightFeet) {
        this.heightFeet = heightFeet;
    }

    public Integer getHeightInches() {
        return heightInches;
    }

    public void setHeightInches(Integer heightInches) {
        this.heightInches = heightInches;
    }

    public List<BodyWeight> getBodyWeightHistory() {
        return bodyWeightHistory;
    }

    public void setBodyWeightHistory(List<BodyWeight> bodyWeightHistory) {
        this.bodyWeightHistory = bodyWeightHistory;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }

}
