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

    @PostMapping("/add_orden/{id_user}")
    public ResponseEntity<?> addOrden(@PathVariable String id_user, @RequestBody List<List_Producto_Cantidad_Request> productos){
        try {
            return new ResponseEntity<>(ordenService.addOrden(id_user,productos), HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage()+", cause:\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
