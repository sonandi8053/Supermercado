package com.example.ProyectoSupermercado.Mapper;

import com.example.ProyectoSupermercado.DTO.Request.DetallesReposicionRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.DetallesReposicionResponseDTO;
import com.example.ProyectoSupermercado.Entity.DetalleReposicion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DetalleReposicionMapper {
    @Mapping(source = "reposicion.id", target = "idReposicion")
    @Mapping(source = "producto.id", target = "idProducto")
    DetallesReposicionResponseDTO toDTO(DetalleReposicion detalleReposicion);
    DetalleReposicion toEntity(DetallesReposicionRequestDTO dto);
}
