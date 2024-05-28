package org.service.microserviceproducto.requests_responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.service.microserviceproducto.entities.ProductoEntity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductoResponse {

    private String message;
    private ProductoEntity productoEntity;

}
