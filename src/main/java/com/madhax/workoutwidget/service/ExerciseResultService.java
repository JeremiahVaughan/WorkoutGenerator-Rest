package com.madhax.workoutwidget.service;

import com.madhax.workoutwidget.model.ExerciseResult;
import com.madhax.workoutwidget.repository.ExerciseResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseResultService {

    private final ExerciseResultRepository exerciseResultRepository;

    public ExerciseResultService(ExerciseResultRepository exerciseResultRepository) {
        this.exerciseResultRepository = exerciseResultRepository;
    }

    public List<ExerciseResult> getAll() {
        return (List) exerciseResultRepository.findAll();
    }

    public ExerciseResult getById(Long id) {
        return exerciseResultRepository.findById(id).orElse(null);
    }

    public ExerciseResult save(ExerciseResult exerciseResult) {
        return exerciseResultRepository.save(exerciseResult);
    }

    public void delete(ExerciseResult exerciseResult) {
        exerciseResultRepository.delete(exerciseResult);
    }

    public void deleteById(Long id) {
        exerciseResultRepository.deleteById(id);
    }
}
