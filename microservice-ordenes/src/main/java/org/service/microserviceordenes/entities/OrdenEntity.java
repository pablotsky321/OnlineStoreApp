package org.service.microserviceordenes.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.service.microserviceordenes.DTOs.UserDTO;
import org.springframework.data.mongodb.core.mapping.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Ordenes")
public class OrdenEntity {

    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;
    private List<Producto_Cantidad> productos;
    @DocumentReference(collection = "Usuarios")
    @Field(name = "id_usuario")
    private UserDTO userDTO;
    private LocalDateTime fecha;

}
