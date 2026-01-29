package com.example.ProyectoSupermercado.Mapper;

import com.example.ProyectoSupermercado.DTO.Request.UsuarioRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.UsuarioResponseDTO;
import com.example.ProyectoSupermercado.Entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioResponseDTO toDTO(Usuario usuario);
    Usuario toEntity(UsuarioRequestDTO dto);
}
