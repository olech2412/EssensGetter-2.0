package com.example.essensgetter_2_0.JPA.services.mensen;

import com.example.essensgetter_2_0.JPA.repository.mensen.Mensa_AcademicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Mensa_AcademicaService extends Mensa_Service{

    @Autowired
    Mensa_AcademicaRepository mensa_academicaRepository;
}
