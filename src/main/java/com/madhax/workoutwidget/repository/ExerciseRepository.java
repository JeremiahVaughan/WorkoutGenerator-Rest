package com.madhax.workoutwidget.repository;

import com.madhax.workoutwidget.model.Exercise;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
    List<Exercise> findAllByPersonId(Long id);
}
