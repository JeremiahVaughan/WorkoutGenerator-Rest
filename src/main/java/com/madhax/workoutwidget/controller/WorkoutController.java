package com.madhax.workoutwidget.controller;

import com.madhax.workoutwidget.model.Exercise;
import com.madhax.workoutwidget.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/workouts")
public class WorkoutController {
    @GetMapping("{id}")
    public String showDashboard(@PathVariable Long id, Model model) {

        return "dashboard";
    }
}
