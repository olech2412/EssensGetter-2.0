package com.example.essensgetter_2_0.JPA.services.mensen;

import com.example.essensgetter_2_0.JPA.repository.mensen.Mensa_am_MedizincampusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Mensa_am_MedizincampusService {

    @Autowired
    Mensa_am_MedizincampusRepository mensa_am_medizincampusRepository;
}
