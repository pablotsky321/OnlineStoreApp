package org.service.microserviceproducto.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Productos")
public class ProductoEntity {

    @MongoId(value = FieldType.OBJECT_ID)
    private String id;
    @Field(value = "nombre")
    private String nombre;
    @Field(value = "descripcion")
    private String descripcion;
    @DocumentReference
    @Field(value = "categoria_id")
    private CategoriaEntity categoria;
    @Field(value = "stock_disponible")
    private long stock_disponible;
    @Field(value = "precio")
    private double precio;

    public ProductoEntity(String nombre,  String descripcion,long stock_disponible ,double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock_disponible = stock_disponible;
        this.precio = precio;
    }
}
