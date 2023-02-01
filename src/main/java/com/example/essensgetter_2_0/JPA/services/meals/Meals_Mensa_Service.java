package com.example.essensgetter_2_0.JPA.services.meals;


import com.example.essensgetter_2_0.JPA.entities.meals.Meal;
import com.example.essensgetter_2_0.JPA.services.Abstract_Service;
import org.springframework.stereotype.Service;

@Service
public abstract class Meals_Mensa_Service extends Abstract_Service {

    @Override
    public abstract Iterable<? extends Meal> findAll();

}
