package com.madhax.workoutwidget.service;

import com.madhax.workoutwidget.model.Exercise;
import com.madhax.workoutwidget.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<Exercise> getAll() {
        return (List) exerciseRepository.findAll();
    }

    public Exercise getById(Long id) {
        return exerciseRepository.findById(id).orElse(null);
    }

    public Exercise save(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public void delete(Exercise exercise) {
        exerciseRepository.delete(exercise);
    }

    public void deleteById(Long id) {
        exerciseRepository.deleteById(id);
    }

}
