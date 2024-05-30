package org.service.microserviceordenes.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class ProductoDTO {
    private String id;
    private String nombre;
    private String descripcion;
    private double precio;
}
