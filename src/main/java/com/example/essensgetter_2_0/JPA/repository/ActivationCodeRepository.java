package com.example.essensgetter_2_0.JPA.repository;

import com.example.essensgetter_2_0.JPA.ActivationCode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

@RepositoryDefinition(domainClass = ActivationCode.class, idClass = Long.class)
public interface ActivationCodeRepository extends CrudRepository<ActivationCode, Long> {

    List<ActivationCode> findByCode(String code);

}
