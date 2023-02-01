package com.example.essensgetter_2_0.JPA.services.mensen;

import com.example.essensgetter_2_0.JPA.repository.mensen.Mensa_am_MedizincampusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Mensa_am_MedizincampusService extends Mensa_Service {

    @Autowired
    Mensa_am_MedizincampusRepository mensa_am_medizincampusRepository;
}
