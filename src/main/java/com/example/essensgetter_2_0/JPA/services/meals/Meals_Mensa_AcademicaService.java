package com.example.essensgetter_2_0.JPA.services.meals;

import com.example.essensgetter_2_0.JPA.repository.meals.Meals_Mensa_AcademicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Meals_Mensa_AcademicaService extends Meals_Mensa_Service{

    @Autowired
    Meals_Mensa_AcademicaRepository meals_mensa_academicaRepository;
}

