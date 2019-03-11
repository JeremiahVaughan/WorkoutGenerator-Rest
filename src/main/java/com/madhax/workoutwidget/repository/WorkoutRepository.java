package com.madhax.workoutwidget.repository;

import com.madhax.workoutwidget.model.Workout;
import org.springframework.data.repository.CrudRepository;

public interface WorkoutRepository extends CrudRepository<Workout, Long> {

}
