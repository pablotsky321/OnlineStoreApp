package org.service.microserviceordenes.controllers;

import org.service.microserviceordenes.requests_responses.List_Producto_Cantidad_Request;
import org.service.microserviceordenes.services.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orden")
public class OrdenController {

    @Autowired
    OrdenService ordenService;

    @GetMapping("/all")
    public ResponseEntity<?> getOrdens(){
        try {
            return new ResponseEntity<>(ordenService.getAllOrdenes(), HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage()+", cause:\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<?> getOrdenById(@PathVariable("id") String id){
        try {
            return new ResponseEntity<>(ordenService.getOrdenById(id), HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage()+", cause:\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/userOrden/{id_user}")
    public ResponseEntity<?> getUserOrdens(@PathVariable("id_user") String id_user){
        try {
            return new ResponseEntity<>(ordenService.getUserOrdens(id_user), HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage()+", cause:\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add_orden/{id_user}")
    public ResponseEntity<?> addOrden(@PathVariable String id_user, @RequestBody List<List_Producto_Cantidad_Request> productos){
        try {
            return new ResponseEntity<>(ordenService.addOrden(id_user,productos), HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage()+", cause:\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
