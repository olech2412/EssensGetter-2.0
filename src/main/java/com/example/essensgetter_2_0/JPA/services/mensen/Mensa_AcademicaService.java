package com.example.essensgetter_2_0.JPA.services.mensen;

import com.example.essensgetter_2_0.JPA.repository.mensen.Mensa_AcademicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Mensa_AcademicaService {

    @Autowired
    Mensa_AcademicaRepository mensa_academicaRepository;
}
