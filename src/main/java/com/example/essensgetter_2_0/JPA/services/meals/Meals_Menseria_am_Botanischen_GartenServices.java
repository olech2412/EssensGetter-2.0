package com.example.essensgetter_2_0.JPA.services.meals;

import com.example.essensgetter_2_0.JPA.repository.meals.Meals_Menseria_am_Botanischen_GartenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Meals_Menseria_am_Botanischen_GartenServices extends Meals_Mensa_Service{

    @Autowired
    Meals_Menseria_am_Botanischen_GartenRepository meals_menseria_am_botanischen_gartenRepository;
}

