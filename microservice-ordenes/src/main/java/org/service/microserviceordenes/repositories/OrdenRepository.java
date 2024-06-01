package org.service.microserviceordenes.repositories;

import org.service.microserviceordenes.DTOs.UserDTO;
import org.service.microserviceordenes.entities.OrdenEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrdenRepository extends MongoRepository<OrdenEntity,String> {

    List<OrdenEntity> findByUsuario(UserDTO usuario);

}
