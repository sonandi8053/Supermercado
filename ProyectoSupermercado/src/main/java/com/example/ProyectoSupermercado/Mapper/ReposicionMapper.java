package com.example.ProyectoSupermercado.Mapper;

import com.example.ProyectoSupermercado.DTO.Request.ReposicionRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.ReposicionResponseDTO;
import com.example.ProyectoSupermercado.Entity.Reposicion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReposicionMapper {
    @Mapping(source = "usuario.id", target = "idUsuario")
    ReposicionResponseDTO toDTO(Reposicion reposicion);
    Reposicion toEntity(ReposicionRequestDTO dto);
}
