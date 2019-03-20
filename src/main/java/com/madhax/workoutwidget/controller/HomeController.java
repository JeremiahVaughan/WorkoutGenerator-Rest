package com.madhax.workoutwidget.controller;

import com.madhax.workoutwidget.model.Person;
import com.madhax.workoutwidget.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping({"", "/", "index", "index.html"})
public class HomeController {

    private final PersonService personService;

    public HomeController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String showIndexPage(Model model) {
        List<Person> people = personService.getAll();
        model.addAttribute("people", people);
        return "index";
    }

}
