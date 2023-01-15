package com.example.essensgetter_2_0.JPA.repository;

import com.example.essensgetter_2_0.JPA.MailUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailUserRepository extends CrudRepository<MailUser, Long> {

    /**
     * Finds all enabled users
     * @param enabled
     * @return
     */
    Iterable<MailUser> findUsersByEnabled(Boolean enabled);

}