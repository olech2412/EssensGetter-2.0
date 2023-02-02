package com.example.essensgetter_2_0.JPA.services.meals;

import com.example.essensgetter_2_0.JPA.entities.meals.Meal;
import com.example.essensgetter_2_0.JPA.entities.meals.Meals_Schoenauer_Str;
import com.example.essensgetter_2_0.JPA.entities.mensen.Mensa;
import com.example.essensgetter_2_0.JPA.entities.mensen.Mensa_Schoenauer_Str;
import com.example.essensgetter_2_0.JPA.repository.meals.Meals_Schoenauer_StrRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Log4j2
public class Meals_Mensa_Schoenauer_StrService extends Meals_Mensa_Service {

    @Autowired
    Meals_Schoenauer_StrRepository meals_schoenauer_strRepository;

    /**
     * @return
     */
    @Override
    public Iterable<Meals_Schoenauer_Str> findAll() {
        return meals_schoenauer_strRepository.findAll();
    }

    /**
     * @param servingDate
     * @return All meals by serving date greater than or equal to serving date from Mensa Schoenauer Str
     */
    @Override
    public List<Meals_Schoenauer_Str> findAllMealsByServingDateGreaterThanEqual(LocalDate servingDate) {
        return meals_schoenauer_strRepository.findAllMealsByServingDateGreaterThanEqual(servingDate);
    }

    /**
     * @param servingDate
     * @return All meals by serving date from Mensa Schoenauer Str
     */
    @Override
    public List<Meals_Schoenauer_Str> findAllMealsByServingDate(LocalDate servingDate) {
        return meals_schoenauer_strRepository.findAllMealsByServingDate(servingDate);
    }

    /**
     * @param meal
     */
    @Override
    public void save(Meal meal, Mensa mensa) {
        Meals_Schoenauer_Str meals_schoenauer_str = new Meals_Schoenauer_Str();
        meals_schoenauer_str.setId(meal.getId());
        meals_schoenauer_str.setName(meal.getName());
        meals_schoenauer_str.setCategory(meal.getCategory());
        meals_schoenauer_str.setPrice(meal.getPrice());
        meals_schoenauer_str.setServingDate(meal.getServingDate());
        meals_schoenauer_str.setDescription(meal.getDescription());
        meals_schoenauer_str.setRating(meal.getRating());
        meals_schoenauer_str.setVotes(meal.getVotes());
        meals_schoenauer_str.setStarsTotal(meal.getStarsTotal());
        meals_schoenauer_str.setResponseCode(meal.getResponseCode());

        Mensa_Schoenauer_Str mensa_schoenauer_str = new Mensa_Schoenauer_Str();
        mensa_schoenauer_str.setId(mensa.getId());
        mensa_schoenauer_str.setName(mensa.getName());
        mensa_schoenauer_str.setApiUrl(mensa.getApiUrl());

        meals_schoenauer_str.setMensa_schoenauer_str(mensa_schoenauer_str);

        meals_schoenauer_strRepository.save(meals_schoenauer_str);
    }

    /**
     * @param meal
     * @param mensa
     */
    @Override
    public void delete(Meal meal, Mensa mensa) {
        Meals_Schoenauer_Str meals_schoenauer_str = new Meals_Schoenauer_Str();
        meals_schoenauer_str.setId(meal.getId());
        meals_schoenauer_str.setName(meal.getName());
        meals_schoenauer_str.setCategory(meal.getCategory());
        meals_schoenauer_str.setPrice(meal.getPrice());
        meals_schoenauer_str.setServingDate(meal.getServingDate());
        meals_schoenauer_str.setDescription(meal.getDescription());
        meals_schoenauer_str.setRating(meal.getRating());
        meals_schoenauer_str.setVotes(meal.getVotes());
        meals_schoenauer_str.setStarsTotal(meal.getStarsTotal());
        meals_schoenauer_str.setResponseCode(meal.getResponseCode());

        Mensa_Schoenauer_Str mensa_schoenauer_str = new Mensa_Schoenauer_Str();
        mensa_schoenauer_str.setId(mensa.getId());
        mensa_schoenauer_str.setName(mensa.getName());
        mensa_schoenauer_str.setApiUrl(mensa.getApiUrl());

        meals_schoenauer_str.setMensa_schoenauer_str(mensa_schoenauer_str);

        meals_schoenauer_strRepository.delete(meals_schoenauer_str);
        log.warn("Meal deleted: " + meal.getName() + " from " + mensa.getName());
    }
}

