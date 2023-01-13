package com.example.essensgetter_2_0.JPA.repository;

import com.example.essensgetter_2_0.JPA.authentification.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Users.class, idClass = Long.class)
public interface UsersRepository extends CrudRepository<Users, Long> {

}
