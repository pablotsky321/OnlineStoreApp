package org.service.microserviceproducto.repositories;

import org.service.microserviceproducto.entities.CategoriaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface CategoriaRepository extends MongoRepository<CategoriaEntity, String> {

    @Query("{nombre: ?0}")
    Optional<CategoriaEntity> findByNombre(String nombre);

}
