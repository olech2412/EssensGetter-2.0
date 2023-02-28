package com.example.essensgetter_2_0.JPA.repository.meals;

import com.example.essensgetter_2_0.JPA.entities.meals.Meal;
import com.example.essensgetter_2_0.JPA.entities.meals.Meals_Schoenauer_Str;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface Meals_Schoenauer_StrRepository extends CrudRepository<Meals_Schoenauer_Str, Long> {

    List<Meals_Schoenauer_Str> findAllMealsByServingDateGreaterThanEqual(LocalDate servingDate);

    List<Meals_Schoenauer_Str> findAllMealsByServingDate(LocalDate servingDate);

    List<Meals_Schoenauer_Str> findMeals_Schoenauer_StrByNameAndServingDateBeforeOrderByServingDateDesc(String name, LocalDate servingDate);

}