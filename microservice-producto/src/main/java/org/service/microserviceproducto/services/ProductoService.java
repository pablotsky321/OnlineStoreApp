package org.service.microserviceproducto.services;

import org.service.microserviceproducto.entities.CategoriaEntity;
import org.service.microserviceproducto.entities.ProductoEntity;
import org.service.microserviceproducto.repositories.CategoriaRepository;
import org.service.microserviceproducto.repositories.ProductoRepository;
import org.service.microserviceproducto.requests_responses.ProductoFeignResponse;
import org.service.microserviceproducto.requests_responses.ProductoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<ProductoEntity> getAllproductos(){
        return productoRepository.findAll();
    }

    public ProductoEntity getProductoByid(String id){
        return productoRepository.findById(id).orElse(null);
    }

    public ProductoEntity getProductoByNombre(String nombre){
        return productoRepository.findByNombre(nombre.toLowerCase()).orElse(null);
    }

    public List<ProductoEntity> getProductosByCategory(String nombreCategoria){
        return productoRepository.findByCategoria(categoriaRepository.findByNombre(nombreCategoria.toUpperCase()).orElse(null));
    }

    public ProductoResponse addProducto(ProductoEntity producto, String nombreCategoria){
        if(categoriaRepository.findByNombre(nombreCategoria.toUpperCase()).isEmpty()){
            return new ProductoResponse("Categoria no ha sido encontrada",null);
        }else{
            producto.setCategoria(categoriaRepository.findByNombre(nombreCategoria.toUpperCase()).get());
            producto.setNombre(producto.getNombre().toLowerCase());
            ProductoEntity savedProducto = productoRepository.save(producto);
            return new ProductoResponse("Producto agregado", savedProducto);
        }
    }

    public ProductoResponse updateProducto(ProductoEntity producto){
        if(productoRepository.findByNombre(producto.getNombre().toLowerCase()).isEmpty()){
            return new ProductoResponse("Producto no ha sido encontrado",null);
        }else{
            ProductoEntity savedProducto = productoRepository.save(producto);
            return new ProductoResponse("Producto actualizado", savedProducto);
        }
    }

    public ProductoResponse deleteProductoById(String id){
        if(productoRepository.findById(id).isEmpty()){
            return new ProductoResponse("Producto no encontrado",null);
        }else{
            productoRepository.deleteById(id);
            return new ProductoResponse("Producto con id: "+id+" ha sido borrado",null);
        }
    }

    public String addCategoria(CategoriaEntity categoria){
        if(categoriaRepository.findByNombre(categoria.getNombre().toUpperCase()).isPresent()){
            return "la categoria "+categoria.getNombre()+" ya existe";
        }else{
            categoria.setNombre(categoria.getNombre().toUpperCase());
            categoriaRepository.save(categoria);
            return "la categoria "+categoria.getNombre()+" ha sido agregada";
        }
    }

    public String deleteCategoriaById(String id){
        if(categoriaRepository.findById(id).isEmpty()){
            return "la categoria con id: "+id+" no existe";
        }else{
            categoriaRepository.deleteById(id);
            return "la categoria "+id+" ha sido eliminada";
        }
    }

    public String updateCategoria(CategoriaEntity categoria){
        if(categoriaRepository.findByNombre(categoria.getNombre().toUpperCase()).isEmpty()){
            return "la categoria "+categoria.getNombre()+" no existe";
        }else{
            categoriaRepository.save(categoria);
            return "la categoria "+categoria.getNombre()+" ha sido actualizada";
        }
    }

    public ProductoFeignResponse getProducto_Orden(String id){
        Optional<ProductoEntity> productoFind = productoRepository.findById(id);
        if(productoFind.isEmpty()){
            return null;
        }else{
            return ProductoFeignResponse
                    .builder()
                    .id(productoFind.get().getId())
                    .nombre(productoFind.get().getNombre())
                    .descripcion(productoFind.get().getDescripcion())
                    .precio(productoFind.get().getPrecio())
                    .build();
        }
    }

}
