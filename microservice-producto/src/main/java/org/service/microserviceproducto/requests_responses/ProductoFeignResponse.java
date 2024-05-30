package org.service.microserviceproducto.requests_responses;

import lombok.*;
import org.service.microserviceproducto.entities.CategoriaEntity;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoFeignResponse {
    private String id;
    private String nombre;
    private String descripcion;
    private double precio;
}
