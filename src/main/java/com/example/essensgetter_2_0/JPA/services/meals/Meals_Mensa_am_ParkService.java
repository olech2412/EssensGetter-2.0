package com.example.essensgetter_2_0.JPA.services.meals;

import com.example.essensgetter_2_0.JPA.entities.meals.Meal;
import com.example.essensgetter_2_0.JPA.entities.meals.Meals_Mensa_am_Park;
import com.example.essensgetter_2_0.JPA.entities.mensen.Mensa;
import com.example.essensgetter_2_0.JPA.entities.mensen.Mensa_am_Park;
import com.example.essensgetter_2_0.JPA.repository.meals.Meals_Mensa_am_ParkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class Meals_Mensa_am_ParkService extends Meals_Mensa_Service {

    @Autowired
    Meals_Mensa_am_ParkRepository meals_mensa_am_parkRepository;

    /**
     * @return Meals Mensa am Park
     */
    @Override
    public Iterable<Meals_Mensa_am_Park> findAll() {
        return meals_mensa_am_parkRepository.findAll();
    }

    /**
     * @param servingDate
     * @return All meals by serving date greater than or equal to serving date from Mensa am Park
     */
    @Override
    public List<Meals_Mensa_am_Park> findAllMealsByServingDateGreaterThanEqual(LocalDate servingDate) {
        return meals_mensa_am_parkRepository.findAllMealsByServingDateGreaterThanEqual(servingDate);
    }

    /**
     * @param servingDate
     * @return All meals by serving date from Mensa am Park
     */
    @Override
    public List<Meals_Mensa_am_Park> findAllMealsByServingDate(LocalDate servingDate) {
        return meals_mensa_am_parkRepository.findAllMealsByServingDate(servingDate);
    }

    /**
     * @param meal
     * @param mensa
     */
    @Override
    public void save(Meal meal, Mensa mensa) {
        Meals_Mensa_am_Park meals_mensa_am_park = new Meals_Mensa_am_Park();
        meals_mensa_am_park.setId(meal.getId());
        meals_mensa_am_park.setName(meal.getName());
        meals_mensa_am_park.setCategory(meal.getCategory());
        meals_mensa_am_park.setPrice(meal.getPrice());
        meals_mensa_am_park.setServingDate(meal.getServingDate());
        meals_mensa_am_park.setDescription(meal.getDescription());
        meals_mensa_am_park.setRating(meal.getRating());
        meals_mensa_am_park.setVotes(meal.getVotes());
        meals_mensa_am_park.setStarsTotal(meal.getStarsTotal());
        meals_mensa_am_park.setResponseCode(meal.getResponseCode());

        Mensa_am_Park mensa_am_park = new Mensa_am_Park();
        mensa_am_park.setId(mensa.getId());
        mensa_am_park.setName(mensa.getName());
        mensa_am_park.setApiUrl(mensa.getApiUrl());

        meals_mensa_am_park.setMensa_am_park(mensa_am_park);

        meals_mensa_am_parkRepository.save(meals_mensa_am_park);
    }

    /**
     * @param meal
     */
    @Override
    public void delete(Meal meal) {
        meals_mensa_am_parkRepository.delete((Meals_Mensa_am_Park) meal);
    }
}

