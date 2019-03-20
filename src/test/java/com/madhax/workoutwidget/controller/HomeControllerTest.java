package com.madhax.workoutwidget.controller;

import com.madhax.workoutwidget.model.Person;
import com.madhax.workoutwidget.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class HomeControllerTest {

    @Mock
    PersonService personService;

    @InjectMocks
    HomeController controller;

    MockMvc mockMvc;

    List<Person> people;

    @BeforeEach
    void setUp() {

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        Person person1 = new Person();
        person1.setId(1L);
        person1.setFirstName("John");
        person1.setLastName("Doe");

        Person person2 = new Person();
        person2.setId(2L);
        person2.setFirstName("Susan");
        person2.setLastName("Smith");

        people = Arrays.asList(person1, person2);

    }

    @Test
    void showIndexPage() throws Exception {

        when(personService.getAll()).thenReturn(people);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("people"));

        verify(personService, times(1)).getAll();
    }
}