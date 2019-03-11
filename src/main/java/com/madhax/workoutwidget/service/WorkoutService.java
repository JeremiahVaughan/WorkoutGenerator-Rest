package com.madhax.workoutwidget.service;

import com.madhax.workoutwidget.model.Workout;
import com.madhax.workoutwidget.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public List<Workout> getAll() {
        return (List) workoutRepository.findAll();
    }

    public Workout getById(Long id) {
        return workoutRepository.findById(id).orElse(null);
    }

    public Workout save(Workout workout) {
        return workoutRepository.save(workout);
    }

    public void delete(Workout workout) {
        workoutRepository.delete(workout);
    }

    public void deleteById(Long id) {
        workoutRepository.deleteById(id);
    }

}
