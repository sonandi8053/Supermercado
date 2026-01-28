package com.example.ProyectoSupermercado.Service.Interfaces;

import com.example.ProyectoSupermercado.DTO.Request.ProductoRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.ProductoResponseDTO;

import java.util.List;

public interface ProductoService {
    ProductoResponseDTO crearProducto(ProductoRequestDTO dto);
    void editarProducto(Long id, ProductoRequestDTO dto);
    List<ProductoResponseDTO> listarProductos ();
    void modificarActivo(Long id);
}
