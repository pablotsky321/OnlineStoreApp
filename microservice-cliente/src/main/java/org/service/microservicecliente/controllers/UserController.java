package org.service.microservicecliente.controllers;

import org.service.microservicecliente.entities.UserEntity;
import org.service.microservicecliente.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register_client")
    public ResponseEntity<?> registerClient(@RequestBody UserEntity user){
        try {
            return new ResponseEntity<>(userService.registerCliente(user), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage()+" cause:\n"+e.getCause(), HttpStatus.BAD_REQUEST);
        }
    }

}
