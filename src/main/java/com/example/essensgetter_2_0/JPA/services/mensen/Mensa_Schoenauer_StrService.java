package com.example.essensgetter_2_0.JPA.services.mensen;

import com.example.essensgetter_2_0.JPA.repository.mensen.Mensa_Schoenauer_StrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Mensa_Schoenauer_StrService {

    @Autowired
    Mensa_Schoenauer_StrRepository mensa_schoenauer_strRepository;
}

