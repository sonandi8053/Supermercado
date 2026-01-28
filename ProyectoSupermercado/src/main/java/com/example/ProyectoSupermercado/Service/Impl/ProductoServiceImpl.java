package com.example.ProyectoSupermercado.Service.Impl;

import com.example.ProyectoSupermercado.DTO.Request.ProductoRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.ProductoResponseDTO;
import com.example.ProyectoSupermercado.Entity.Producto;
import com.example.ProyectoSupermercado.Exception.Producto.ProductoNoExisteException;
import com.example.ProyectoSupermercado.Exception.Producto.ProductoYaExisteException;
import com.example.ProyectoSupermercado.Mapper.ProductoMapper;
import com.example.ProyectoSupermercado.Repository.ProductoRepository;
import com.example.ProyectoSupermercado.Service.Interfaces.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoMapper productoMapper;

    @Override
    public ProductoResponseDTO crearProducto(ProductoRequestDTO dto) {
        if (dto == null || dto.getNombre() == null || dto.getNombre().trim().isEmpty() ){
            throw new IllegalArgumentException("El nombre es un campo obligatorio.");
        }
        if (productoRepository.existsByNombre(dto.getNombre())){
            throw new ProductoYaExisteException("El producto ya esta registrado.");
        }
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setEs_activo(dto.getEs_activo());
        productoRepository.save(producto);

        return productoMapper.toDTO(producto);
    }

    @Override
    public void editarProducto(Long id, ProductoRequestDTO dto) {
        Producto producto = productoRepository.findById(id).orElseThrow(()-> new ProductoNoExisteException("El producto no existe."));
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setEs_activo(dto.getEs_activo());
        productoRepository.save(producto);
    }

    @Override
    public List<ProductoResponseDTO> listarProductos() {
        List<Producto> productos = productoRepository.findAll();
        List<ProductoResponseDTO> productoResponseDTOS = new ArrayList<>();
        for (Producto producto: productos){
            productoResponseDTOS.add(productoMapper.toDTO(producto));
        }
        return productoResponseDTOS;
    }

    @Override
    public void modificarActivo(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(()-> new ProductoNoExisteException("El producto no existe."));
        producto.setEs_activo(!producto.getEs_activo());
    }
}
