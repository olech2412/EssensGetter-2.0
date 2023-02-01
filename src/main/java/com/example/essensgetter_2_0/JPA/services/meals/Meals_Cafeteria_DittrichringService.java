package com.example.essensgetter_2_0.JPA.services.meals;

import com.example.essensgetter_2_0.JPA.repository.meals.Meals_Cafeteria_DittrichringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Meals_Cafeteria_DittrichringService extends Meals_Mensa_Service{

    @Autowired
    Meals_Cafeteria_DittrichringRepository meals_cafeteria_dittrichringRepository;
}

