package org.service.microserviceproducto.repositories;

import org.service.microserviceproducto.entities.CategoriaEntity;
import org.service.microserviceproducto.entities.ProductoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends MongoRepository<ProductoEntity,String> {

    @Query("{nombre: ?0}")
    Optional<ProductoEntity> findByNombre(String nombre);

    List<ProductoEntity> findByCategoria(CategoriaEntity categoria);

}
