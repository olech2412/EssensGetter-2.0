package com.example.essensgetter_2_0.JPA.services.meals;

import com.example.essensgetter_2_0.JPA.repository.meals.Meals_Mensa_am_ParkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Meals_Mensa_am_ParkService extends Meals_Mensa_Service{

    @Autowired
    Meals_Mensa_am_ParkRepository meals_mensa_am_parkRepository;
}

