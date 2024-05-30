package org.service.microserviceordenes.repositories;

import org.service.microserviceordenes.entities.OrdenEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrdenRepository extends MongoRepository<OrdenEntity,String> {
}
