package org.service.microserviceproducto.controllers;

import org.service.microserviceproducto.entities.CategoriaEntity;
import org.service.microserviceproducto.entities.ProductoEntity;
import org.service.microserviceproducto.requests_responses.ProductoRequest;
import org.service.microserviceproducto.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllProductos() {
        try {
            return new ResponseEntity<>(productoService.getAllproductos(), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage()+" cause:\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<?> getProductoById(@PathVariable(value = "id") String id) {
        try {
            return new ResponseEntity<>(productoService.getProductoByid(id), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage()+" cause:\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/productoByNombre")
    public ResponseEntity<?> getProductoByNombre(@RequestParam(value = "nombre") String nombre) {
        try {
            return new ResponseEntity<>(productoService.getProductoByNombre(nombre), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage()+" cause:\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/productoByCategoria")
    public ResponseEntity<?> getAllProductosByCategoria(@RequestParam(value = "nombreCategoria") String nombreCategoria) {
        try {
            return new ResponseEntity<>(productoService.getProductosByCategory(nombreCategoria), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage()+" cause:\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addProducto")
    public ResponseEntity<?> insertProducto(@RequestBody ProductoEntity producto, @RequestParam("nombreCategoria") String nombreCategoria) {
        try {
            return new ResponseEntity<>(productoService.addProducto(producto,nombreCategoria), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage()+" cause:\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addCategoria")
    public ResponseEntity<?> insertCategoria(@RequestBody CategoriaEntity categoria) {
        try {
            return new ResponseEntity<>(productoService.addCategoria(categoria), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage()+" cause:\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addCategorias")
    public ResponseEntity<?> insertCategorias(@RequestBody List<CategoriaEntity> categorias) {
        try {
            return new ResponseEntity<>(productoService.addCategories(categorias), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage()+" cause:\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addProductos")
    public ResponseEntity<?> insertProductos(@RequestBody List<ProductoRequest> productos) {
        try {
            return new ResponseEntity<>(productoService.addProductos(productos), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage()+" cause:\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateProducto")
    public ResponseEntity<?> updateProducto(@RequestBody ProductoEntity producto) {
        try {
            return new ResponseEntity<>(productoService.updateProducto(producto), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage()+" cause:\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateCategoria")
    public ResponseEntity<?> updateCategoria(@RequestBody CategoriaEntity categoria) {
        try {
            return new ResponseEntity<>(productoService.updateCategoria(categoria), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage()+" cause:\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteProducto/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable(value = "id") String id) {
        try {
            return new ResponseEntity<>(productoService.deleteProductoById(id), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage()+" cause:\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteCategoria/{id}")
    public ResponseEntity<?> deleteCategoria(@PathVariable(value = "id") String id) {
        try {
            return new ResponseEntity<>(productoService.deleteCategoriaById(id), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage()+" cause:\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findProductoOrden/{id}")
    public ResponseEntity<?> findProductoOrden(@PathVariable(value = "id") String id) {
        try {
            return new ResponseEntity<>(productoService.getProducto_Orden(id), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage()+" cause:\n"+e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
