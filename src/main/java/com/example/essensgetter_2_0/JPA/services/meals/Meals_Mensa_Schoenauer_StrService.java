package com.example.essensgetter_2_0.JPA.services.meals;

import com.example.essensgetter_2_0.JPA.repository.meals.Meals_Schoenauer_StrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Meals_Mensa_Schoenauer_StrService extends Meals_Mensa_Service{

    @Autowired
    Meals_Schoenauer_StrRepository meals_schoenauer_strRepository;
}

