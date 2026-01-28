package com.example.ProyectoSupermercado.Mapper;

import com.example.ProyectoSupermercado.DTO.Request.UsuarioRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.UsuarioResponseDTO;
import com.example.ProyectoSupermercado.Entity.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-28T12:12:35-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioResponseDTO toDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();

        return usuarioResponseDTO;
    }

    @Override
    public Usuario toEntity(UsuarioRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setNombre( dto.getNombre() );
        usuario.setEmail( dto.getEmail() );
        usuario.setFecha_nac( dto.getFecha_nac() );
        usuario.setRol( dto.getRol() );

        return usuario;
    }
}
