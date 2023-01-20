package com.example.essensgetter_2_0.JPA.repository;

import com.example.essensgetter_2_0.JPA.Meal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MealRepository extends CrudRepository<Meal, Long> {

    Meal findByName(String name);
    List<Meal> findAllByServingDateGreaterThanEqual(LocalDate date);

    List<Meal> findAllByServingDate(LocalDate date);

    List<Meal> findAllByNameAndServingDateBeforeOrderByServingDateAsc(String name, LocalDate date);

}
