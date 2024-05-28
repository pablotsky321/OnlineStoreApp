package org.service.microservicecliente.repositories;

import org.service.microservicecliente.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEntity,String> {

    @Query("{username : ?0}")
    Optional<UserEntity> findByUsername(String username);

}
