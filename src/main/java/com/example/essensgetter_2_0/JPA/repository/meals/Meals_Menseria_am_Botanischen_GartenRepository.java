package com.example.essensgetter_2_0.JPA.repository.meals;

import com.example.essensgetter_2_0.JPA.entities.meals.Meals_Mensa_Tierklinik;
import com.example.essensgetter_2_0.JPA.entities.meals.Meals_Menseria_am_Botanischen_Garten;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface Meals_Menseria_am_Botanischen_GartenRepository extends CrudRepository<Meals_Menseria_am_Botanischen_Garten, Long> {

    List<Meals_Menseria_am_Botanischen_Garten> findAllMealsByServingDateGreaterThanEqual(LocalDate servingDate);

    List<Meals_Menseria_am_Botanischen_Garten> findAllMealsByServingDate(LocalDate servingDate);

    List<Meals_Menseria_am_Botanischen_Garten> findMeals_Menseria_am_Botanischen_GartenByNameAndServingDateBeforeOrderByServingDateDesc(String name, LocalDate servingDate);

}