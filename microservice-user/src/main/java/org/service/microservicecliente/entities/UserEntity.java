package org.service.microservicecliente.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Usuarios")
public class UserEntity {

    @MongoId(value = FieldType.OBJECT_ID)
    private String id;
    @Field(name = "nombres")
    private String nombres;
    @Field(name = "apellidos")
    private String apellidos;
    @Email
    @Field(name = "correo_electronico")
    @Indexed(unique = true)
    private String username;
    @Field(name = "clave")
    private String password;
    @JsonIgnore
    @Field(name = "rol")
    private ROLE role;
    @JsonIgnore
    @Field(name = "permisos")
    private List<GrantedAuthority> grantedAuthorities;

    public UserEntity(String nombres, String apellidos, String username, String password) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.username = username;
        this.password = password;
    }

}

