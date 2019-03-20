package com.madhax.workoutwidget.controller;

import com.madhax.workoutwidget.model.Exercise;
import com.madhax.workoutwidget.model.Person;
import com.madhax.workoutwidget.service.ExerciseService;
import com.madhax.workoutwidget.service.PersonService;
import com.madhax.workoutwidget.service.WorkoutService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private final PersonService personService;
    private final WorkoutService workoutService;
    private final ExerciseService exerciseService;

    public DashboardController(PersonService personService, WorkoutService workoutService, ExerciseService exerciseService) {
        this.personService = personService;
        this.workoutService = workoutService;
        this.exerciseService = exerciseService;
    }

    @GetMapping("{id}")
    public String showDashboard(@PathVariable Long id, Model model) {
        Person person = personService.getById(id);
        List<Exercise> exercises = exerciseService.getAllByPersonId(person.getId());
        model.addAttribute("person", person);
        model.addAttribute("exercises", exercises);
        return "dashboard";
    }

}
