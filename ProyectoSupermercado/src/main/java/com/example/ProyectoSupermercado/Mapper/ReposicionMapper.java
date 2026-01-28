package com.example.ProyectoSupermercado.Mapper;

import com.example.ProyectoSupermercado.DTO.Request.ReposicionRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.ReposicionResponseDTO;
import com.example.ProyectoSupermercado.Entity.Reposicion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReposicionMapper {
    ReposicionResponseDTO toDTO(Reposicion reposicion);
    Reposicion toEntity(ReposicionRequestDTO dto);
}
