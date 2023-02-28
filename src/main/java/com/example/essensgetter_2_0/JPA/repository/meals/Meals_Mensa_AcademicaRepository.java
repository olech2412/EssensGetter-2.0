package com.example.essensgetter_2_0.JPA.repository.meals;

import com.example.essensgetter_2_0.JPA.entities.meals.Meals_Mensa_Academica;
import com.example.essensgetter_2_0.JPA.entities.meals.Meals_Schoenauer_Str;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface Meals_Mensa_AcademicaRepository extends CrudRepository<Meals_Mensa_Academica, Long> {

    List<Meals_Mensa_Academica> findAllMealsByServingDateGreaterThanEqual(LocalDate servingDate);

    List<Meals_Mensa_Academica> findAllMealsByServingDate(LocalDate servingDate);

    List<Meals_Mensa_Academica> findMeals_Mensa_AcademicaByNameAndServingDateBeforeOrderByServingDateDesc(String name, LocalDate servingDate);

}