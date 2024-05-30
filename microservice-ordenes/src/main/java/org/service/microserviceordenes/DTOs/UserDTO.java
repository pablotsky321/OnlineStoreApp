package org.service.microserviceordenes.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class UserDTO {

    private String id;
    private String nombres;
    private String apellidos;
    private String username;

}
