package org.service.microserviceproducto.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "Categorias")
public class CategoriaEntity {

    @MongoId(value = FieldType.OBJECT_ID)
    private String id;
    private String nombre;

    public CategoriaEntity(String nombre) {
        this.nombre = nombre;
    }
}
