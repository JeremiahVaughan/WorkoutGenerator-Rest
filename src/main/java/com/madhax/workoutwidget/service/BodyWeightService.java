package com.madhax.workoutwidget.service;

import com.madhax.workoutwidget.model.BodyWeight;
import com.madhax.workoutwidget.repository.BodyWeightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BodyWeightService {

    private final BodyWeightRepository bodyWeightRepository;

    public BodyWeightService(BodyWeightRepository bodyWeightRepository) {
        this.bodyWeightRepository = bodyWeightRepository;
    }

    public List<BodyWeight> getAll() {
        return (List) bodyWeightRepository.findAll();
    }

    public BodyWeight getById(Long id) {
        return bodyWeightRepository.findById(id).orElse(null);
    }

    public BodyWeight save(BodyWeight bodyWeight) {
        return bodyWeightRepository.save(bodyWeight);
    }

    public void delete(BodyWeight bodyWeight) {
        bodyWeightRepository.delete(bodyWeight);
    }

    public void deleteById(Long id) {
        bodyWeightRepository.deleteById(id);
    }
}
