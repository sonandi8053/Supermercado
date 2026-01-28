package com.example.ProyectoSupermercado.Mapper;

import com.example.ProyectoSupermercado.DTO.Request.ProductoRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.ProductoResponseDTO;
import com.example.ProyectoSupermercado.Entity.Producto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    ProductoResponseDTO toDTO(Producto producto);
    Producto toEntity(ProductoRequestDTO dto);
}
