package com.example.essensgetter_2_0.JPA.services.mensen;

import com.example.essensgetter_2_0.JPA.repository.mensen.Mensa_am_ElsterbeckenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Mensa_am_ElsterbeckenService {

    @Autowired
    Mensa_am_ElsterbeckenRepository mensa_am_elsterbeckenRepository;
}

