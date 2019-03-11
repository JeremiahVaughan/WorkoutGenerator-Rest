package com.madhax.workoutwidget.repository;

import com.madhax.workoutwidget.model.Exercise;
import org.springframework.data.repository.CrudRepository;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {

}
