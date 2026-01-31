package com.example.ProyectoSupermercado.Mapper;

import com.example.ProyectoSupermercado.DTO.Request.UsuarioRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.UsuarioResponseDTO;
import com.example.ProyectoSupermercado.Entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    @Mapping(target = "pedidos", ignore = true)
    @Mapping(target = "movimientoStocks", ignore = true)
    @Mapping(target = "reposiciones", ignore = true)
    @Mapping(target = "contraseniaHash", ignore = true)
    Usuario toEntity(UsuarioRequestDTO dto);
    UsuarioResponseDTO toDTO(Usuario usuario);

}
