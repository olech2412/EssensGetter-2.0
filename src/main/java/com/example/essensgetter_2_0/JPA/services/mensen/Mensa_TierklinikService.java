package com.example.essensgetter_2_0.JPA.services.mensen;

import com.example.essensgetter_2_0.JPA.repository.mensen.Mensa_TierklinikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Mensa_TierklinikService extends Mensa_Service{

    @Autowired
    Mensa_TierklinikRepository mensa_tierklinikRepository;
}

