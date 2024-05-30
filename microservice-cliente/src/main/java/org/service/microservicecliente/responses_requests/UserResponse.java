package org.service.microservicecliente.responses_requests;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private String id;
    private String nombres;
    private String apellidos;
    private String username;

}
