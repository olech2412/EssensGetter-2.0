package com.example.essensgetter_2_0.JPA.repository.meals;

import com.example.essensgetter_2_0.JPA.entities.meals.Meals_Mensa_am_Elsterbecken;
import com.example.essensgetter_2_0.JPA.entities.meals.Meals_Mensa_am_Medizincampus;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface Meals_Mensa_am_MedizincampusRepository extends CrudRepository<Meals_Mensa_am_Medizincampus, Long> {

    List<Meals_Mensa_am_Medizincampus> findAllMealsByServingDateGreaterThanEqual(LocalDate servingDate);

    List<Meals_Mensa_am_Medizincampus> findAllMealsByServingDate(LocalDate servingDate);

    List<Meals_Mensa_am_Medizincampus> findMeals_Mensa_am_MedizincampusByNameAndServingDateBeforeOrderByServingDateDesc(String name, LocalDate servingDate);


}