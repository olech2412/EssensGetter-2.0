package com.example.essensgetter_2_0.JPA.repository;

import com.example.essensgetter_2_0.JPA.Meal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Meal.class, idClass = Long.class)
public interface MealRepository extends CrudRepository<Meal, Long> {


}
