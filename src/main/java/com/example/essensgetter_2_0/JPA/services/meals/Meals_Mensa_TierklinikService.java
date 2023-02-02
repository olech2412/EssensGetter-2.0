package com.example.essensgetter_2_0.JPA.services.meals;

import com.example.essensgetter_2_0.JPA.entities.meals.Meal;
import com.example.essensgetter_2_0.JPA.entities.meals.Meals_Mensa_Tierklinik;
import com.example.essensgetter_2_0.JPA.entities.meals.Meals_Schoenauer_Str;
import com.example.essensgetter_2_0.JPA.entities.mensen.Mensa;
import com.example.essensgetter_2_0.JPA.entities.mensen.Mensa_Schoenauer_Str;
import com.example.essensgetter_2_0.JPA.entities.mensen.Mensa_Tierklinik;
import com.example.essensgetter_2_0.JPA.repository.meals.Meals_Mensa_TierklinikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class Meals_Mensa_TierklinikService extends Meals_Mensa_Service{

    @Autowired
    Meals_Mensa_TierklinikRepository meals_mensa_tierklinikRepository;

    /**
     * @return Meals Mensa Tierklinik
     */
    @Override
    public Iterable<Meals_Mensa_Tierklinik> findAll() {
        return meals_mensa_tierklinikRepository.findAll();
    }

    /**
     * @param servingDate
     * @return All meals by serving date greater than or equal to serving date from Mensa Tierklinik
     */
    @Override
    public List<Meals_Mensa_Tierklinik> findAllMealsByServingDateGreaterThanEqual(LocalDate servingDate) {
        return meals_mensa_tierklinikRepository.findAllMealsByServingDateGreaterThanEqual(servingDate);
    }

    /**
     * @param servingDate
     * @return All meals by serving date from Mensa Tierklinik
     */
    @Override
    public List<Meals_Mensa_Tierklinik> findAllMealsByServingDate(LocalDate servingDate) {
        return meals_mensa_tierklinikRepository.findAllMealsByServingDate(servingDate);
    }

    /**
     * @param meal
     * @param mensa
     */
    @Override
    public void save(Meal meal, Mensa mensa) {
        Meals_Mensa_Tierklinik meals_mensa_tierklinik = new Meals_Mensa_Tierklinik();
        meals_mensa_tierklinik.setId(meal.getId());
        meals_mensa_tierklinik.setName(meal.getName());
        meals_mensa_tierklinik.setCategory(meal.getCategory());
        meals_mensa_tierklinik.setPrice(meal.getPrice());
        meals_mensa_tierklinik.setServingDate(meal.getServingDate());
        meals_mensa_tierklinik.setDescription(meal.getDescription());
        meals_mensa_tierklinik.setRating(meal.getRating());
        meals_mensa_tierklinik.setVotes(meal.getVotes());
        meals_mensa_tierklinik.setStarsTotal(meal.getStarsTotal());
        meals_mensa_tierklinik.setResponseCode(meal.getResponseCode());

        Mensa_Tierklinik mensa_tierklinik = new Mensa_Tierklinik();
        mensa_tierklinik.setId(mensa.getId());
        mensa_tierklinik.setName(mensa.getName());
        mensa_tierklinik.setApiUrl(mensa.getApiUrl());

        meals_mensa_tierklinik.setMensa_tierklinik(mensa_tierklinik);

        meals_mensa_tierklinikRepository.save(meals_mensa_tierklinik);
    }

    /**
     * @param meal
     */
    @Override
    public void delete(Meal meal) {
        meals_mensa_tierklinikRepository.delete((Meals_Mensa_Tierklinik) meal);
    }
}

