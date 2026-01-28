package com.example.ProyectoSupermercado.Mapper;

import com.example.ProyectoSupermercado.DTO.Request.DetallesReposicionRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.DetallesReposicionResponseDTO;
import com.example.ProyectoSupermercado.Entity.DetalleReposicion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DetalleReposicionMapper {
    DetallesReposicionResponseDTO toDTO(DetalleReposicion detalleReposicion);
    DetalleReposicion toEntity(DetallesReposicionRequestDTO dto);
}
