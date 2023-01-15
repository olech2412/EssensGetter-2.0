package com.example.essensgetter_2_0.JPA.service;

import com.example.essensgetter_2_0.JPA.authentification.Users;
import com.example.essensgetter_2_0.JPA.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    /**
     * Get all users that are enabled
     */
    public Iterable<Users> findAllUsersThatAreEnabled(){
        return usersRepository.findUsersByEnabled(true);
    }
}
