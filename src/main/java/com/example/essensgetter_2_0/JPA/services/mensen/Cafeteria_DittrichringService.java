package com.example.essensgetter_2_0.JPA.services.mensen;

import com.example.essensgetter_2_0.JPA.repository.mensen.Cafeteria_DittrichringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Cafeteria_DittrichringService {

    @Autowired
    Cafeteria_DittrichringRepository cafeteria_dittrichringRepository;
}
