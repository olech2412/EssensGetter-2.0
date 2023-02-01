package com.example.essensgetter_2_0.JPA.services.meals;

import com.example.essensgetter_2_0.JPA.entities.meals.Meals_Mensa_Peterssteinweg;
import com.example.essensgetter_2_0.JPA.repository.meals.Meals_Mensa_PeterssteinwegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Meals_Mensa_PeterssteinwegService extends Meals_Mensa_Service{

    @Autowired
    Meals_Mensa_PeterssteinwegRepository meals_mensa_peterssteinwegRepository;

    /**
     * @return Meals Mensa Peterssteinweg
     */
    @Override
    public Iterable<Meals_Mensa_Peterssteinweg> findAll() {
        return meals_mensa_peterssteinwegRepository.findAll();
    }
}

