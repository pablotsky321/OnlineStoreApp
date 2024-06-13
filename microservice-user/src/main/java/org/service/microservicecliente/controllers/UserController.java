package org.service.microservicecliente.controllers;

import jakarta.validation.Valid;
import org.service.microservicecliente.entities.UserEntity;
import org.service.microservicecliente.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register_client")
    public ResponseEntity<?> registerClient(@Valid @RequestBody UserEntity user){
        try {
            return new ResponseEntity<>(userService.registerCliente(user), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage()+" cause:\n"+e.getCause(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/search_user/{id}")
    public ResponseEntity<?> searchUserById(@PathVariable(value = "id") String id){
        try {
            return new ResponseEntity<>(userService.findUserByid(id), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage()+" cause:\n"+e.getCause(), HttpStatus.BAD_REQUEST);
        }
    }

}
