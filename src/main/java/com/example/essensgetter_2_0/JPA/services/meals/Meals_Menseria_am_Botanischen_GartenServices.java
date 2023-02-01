package com.example.essensgetter_2_0.JPA.services.meals;

import com.example.essensgetter_2_0.JPA.repository.meals.Meals_Cafeteria_DittrichringRepository;
import com.example.essensgetter_2_0.JPA.repository.meals.Meals_Menseria_am_Botanischen_GartenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Meals_Menseria_am_Botanischen_GartenServices {

    @Autowired
    Meals_Menseria_am_Botanischen_GartenRepository meals_menseria_am_botanischen_gartenRepository;
}

