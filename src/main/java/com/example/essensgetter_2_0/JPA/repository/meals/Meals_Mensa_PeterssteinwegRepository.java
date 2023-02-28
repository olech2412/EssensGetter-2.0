package com.example.essensgetter_2_0.JPA.repository.meals;

import com.example.essensgetter_2_0.JPA.entities.meals.Meals_Mensa_Peterssteinweg;
import com.example.essensgetter_2_0.JPA.entities.meals.Meals_Mensa_am_Park;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface Meals_Mensa_PeterssteinwegRepository extends CrudRepository<Meals_Mensa_Peterssteinweg, Long> {

    List<Meals_Mensa_Peterssteinweg> findAllMealsByServingDateGreaterThanEqual(LocalDate servingDate);

    List<Meals_Mensa_Peterssteinweg> findAllMealsByServingDate(LocalDate servingDate);

    List<Meals_Mensa_Peterssteinweg> findMeals_Mensa_PeterssteinwegByNameAndServingDateBeforeOrderByServingDateDesc(String name, LocalDate servingDate);
}