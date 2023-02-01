package com.example.essensgetter_2_0.JPA.repository;

import com.example.essensgetter_2_0.JPA.entities.DeactivationCode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeactivationCodeRepository extends CrudRepository<DeactivationCode, Long> {

    List<DeactivationCode> findByCode(String code);
}