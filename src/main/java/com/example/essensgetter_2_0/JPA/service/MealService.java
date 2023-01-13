package com.example.essensgetter_2_0.JPA.service;

import com.example.essensgetter_2_0.JPA.Meal;
import com.example.essensgetter_2_0.JPA.repository.MealRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
public class MealService {

    private final MealRepository mealRepository;

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Transactional
    public void saveMeal(Meal meal) {
        mealRepository.save(meal);
        log.info("Meal saved: " + meal);
    }

}
