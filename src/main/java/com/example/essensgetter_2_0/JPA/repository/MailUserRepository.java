package com.example.essensgetter_2_0.JPA.repository;

import com.example.essensgetter_2_0.JPA.entities.MailUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MailUserRepository extends CrudRepository<MailUser, Long> {


    List<MailUser> findByEmail(String email);

    MailUser findByActivationCode_Code(String code);

    MailUser findByDeactivationCode_Code(String code);

    /**
     * Finds all enabled users
     *
     * @param enabled
     * @return
     */
    Iterable<MailUser> findUsersByEnabled(Boolean enabled);


}