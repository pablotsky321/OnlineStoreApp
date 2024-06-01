package org.service.microserviceproducto.requests_responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.service.microserviceproducto.entities.ProductoEntity;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductoRequest {

    private String nombre_categoria;
    private ProductoEntity producto;

}
