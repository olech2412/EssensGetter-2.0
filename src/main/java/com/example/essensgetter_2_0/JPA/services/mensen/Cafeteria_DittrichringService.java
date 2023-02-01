package com.example.essensgetter_2_0.JPA.services.mensen;

import com.example.essensgetter_2_0.JPA.repository.mensen.Cafeteria_DittrichringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Cafeteria_DittrichringService extends Mensa_Service{

    @Autowired
    Cafeteria_DittrichringRepository cafeteria_dittrichringRepository;
}
