package org.service.microserviceordenes.clients;

import org.service.microserviceordenes.DTOs.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservice-user", url = "http://localhost:8090/api/usuario")
public interface UserClient {

    @GetMapping("/search_user/{id_usuario}")
    UserDTO getUserById(@PathVariable(value = "id_usuario") String id_usuario);

}

