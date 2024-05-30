package org.service.microserviceordenes.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.service.microserviceordenes.DTOs.ProductoDTO;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Producto_Cantidad {

    @DocumentReference(collection = "Productos")
    @Field(name = "id_producto")
    private ProductoDTO producto;
    @Field(name = "cantidad")
    private int cantidad;
    @Field(name = "valor_total")
    private double valor_total;

    public Producto_Cantidad(ProductoDTO producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        modifyValorTotal();
    }

    public void modifyValorTotal(){
        this.valor_total = this.producto.getPrecio()*this.cantidad;
    }

}
