package com.example.essensgetter_2_0.JPA.services.mensen;

import com.example.essensgetter_2_0.JPA.repository.mensen.Menseria_am_Botanischen_GartenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Menseria_am_Botanischen_GartenService {

    @Autowired
    Menseria_am_Botanischen_GartenRepository menseria_am_botanischen_gartenRepository;
}

