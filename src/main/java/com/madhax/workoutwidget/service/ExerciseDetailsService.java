package com.madhax.workoutwidget.service;

import com.madhax.workoutwidget.model.ExerciseDetails;
import com.madhax.workoutwidget.repository.ExerciseDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseDetailsService {

    private final ExerciseDetailsRepository exerciseDetailsRepository;

    public ExerciseDetailsService(ExerciseDetailsRepository exerciseDetailsRepository) {
        this.exerciseDetailsRepository = exerciseDetailsRepository;
    }

    public List<ExerciseDetails> getAll() {
        return (List) exerciseDetailsRepository.findAll();
    }

    public ExerciseDetails getById(Long id) {
        return exerciseDetailsRepository.findById(id).orElse(null);
    }

    public ExerciseDetails save(ExerciseDetails exerciseDetails) {
        return exerciseDetailsRepository.save(exerciseDetails);
    }

    public void delete(ExerciseDetails exerciseDetails) {
        exerciseDetailsRepository.delete(exerciseDetails);
    }

    public void deleteById(Long id) {
        exerciseDetailsRepository.deleteById(id);
    }
}
