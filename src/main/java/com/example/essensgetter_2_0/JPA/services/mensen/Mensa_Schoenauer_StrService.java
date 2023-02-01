package com.example.essensgetter_2_0.JPA.services.mensen;

import com.example.essensgetter_2_0.JPA.repository.mensen.Mensa_Schoenauer_StrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Mensa_Schoenauer_StrService extends Mensa_Service{

    @Autowired
    Mensa_Schoenauer_StrRepository mensa_schoenauer_strRepository;
}

