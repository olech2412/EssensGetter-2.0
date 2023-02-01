package com.example.essensgetter_2_0.JPA.services.meals;

import com.example.essensgetter_2_0.JPA.repository.meals.Meals_Cafeteria_DittrichringRepository;
import com.example.essensgetter_2_0.JPA.repository.meals.Meals_Mensa_PeterssteinwegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Meals_Mensa_PeterssteinwegService {

    @Autowired
    Meals_Mensa_PeterssteinwegRepository meals_mensa_peterssteinwegRepository;
}

