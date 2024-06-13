package org.service.microserviceordenes.clients;

import org.service.microserviceordenes.DTOs.ProductoDTO;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservice-producto",url = "${microservice-producto.uri}")
public interface ProductoClient {
    
    @GetMapping("/findProductoOrden/{id_producto}")
    ProductoDTO getProductoById(@PathVariable(value = "id_producto") String id_producto);

}
