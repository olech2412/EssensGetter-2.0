package com.example.essensgetter_2_0.JPA.services.mensen;

import com.example.essensgetter_2_0.JPA.repository.mensen.Mensa_PeterssteinwegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Mensa_PeterssteinwegService extends Mensa_Service{

    @Autowired
    Mensa_PeterssteinwegRepository mensa_peterssteinwegRepository;
}

