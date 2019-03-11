package com.madhax.workoutwidget.repository;

import com.madhax.workoutwidget.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
