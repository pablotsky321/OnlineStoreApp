package org.service.microserviceordenes.services;

import org.service.microserviceordenes.DTOs.UserDTO;
import org.service.microserviceordenes.clients.ProductoClient;
import org.service.microserviceordenes.clients.UserClient;
import org.service.microserviceordenes.entities.OrdenEntity;
import org.service.microserviceordenes.entities.Producto_Cantidad;
import org.service.microserviceordenes.repositories.OrdenRepository;
import org.service.microserviceordenes.requests_responses.List_Producto_Cantidad_Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdenService {

    @Autowired
    OrdenRepository ordenRepository;

    @Autowired
    UserClient userClient;

    @Autowired
    ProductoClient productoClient;

    public OrdenEntity addOrden(String id_user, List<List_Producto_Cantidad_Request> lista_productos) {
        if(userClient.getUserById(id_user) == null) {
            return null;
        }else{
            List<Producto_Cantidad> producto_cantidad = new ArrayList<>();
            OrdenEntity orden = new OrdenEntity();
            orden.setFecha(LocalDateTime.now());
            orden.setUserDTO(userClient.getUserById(id_user));
            for (List_Producto_Cantidad_Request request:lista_productos) {
                if(productoClient.getProductoById(request.getId_producto()) != null){
                    producto_cantidad.add(new Producto_Cantidad(productoClient.getProductoById(request.getId_producto()), request.getCantidad()));
                }
            }
            orden.setProductos(producto_cantidad);
            return ordenRepository.save(orden);
        }
    }

    public List<OrdenEntity> getAllOrdenes() {
        return ordenRepository.findAll();
    }

    public OrdenEntity getOrdenById(String id) {
        return ordenRepository.findById(id).orElse(null);
    }

    public String deleteOrdenById(String id) {
        if(ordenRepository.findById(id).isEmpty()){
            return "La orden no existe";
        }else{
            ordenRepository.deleteById(id);
            return "Orden eliminado";
        }
    }

    public List<OrdenEntity> getUserOrdens(String id_user) {
        if(userClient.getUserById(id_user) == null) {
            return null;
        }else{
            return ordenRepository.findByUserDTO(userClient.getUserById(id_user));
        }
    }

}
