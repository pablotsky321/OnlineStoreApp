package org.service.microserviceordenes.requests_responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class List_Producto_Cantidad_Request {
    private String id_producto;
    private int cantidad;
}
