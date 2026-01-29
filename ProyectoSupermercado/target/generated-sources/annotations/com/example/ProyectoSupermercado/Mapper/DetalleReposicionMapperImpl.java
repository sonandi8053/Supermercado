package com.example.ProyectoSupermercado.Mapper;

import com.example.ProyectoSupermercado.DTO.Request.DetallesReposicionRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.DetallesReposicionResponseDTO;
import com.example.ProyectoSupermercado.Entity.DetalleReposicion;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-28T22:01:15-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class DetalleReposicionMapperImpl implements DetalleReposicionMapper {

    @Override
    public DetallesReposicionResponseDTO toDTO(DetalleReposicion detalleReposicion) {
        if ( detalleReposicion == null ) {
            return null;
        }

        DetallesReposicionResponseDTO detallesReposicionResponseDTO = new DetallesReposicionResponseDTO();

        return detallesReposicionResponseDTO;
    }

    @Override
    public DetalleReposicion toEntity(DetallesReposicionRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        DetalleReposicion detalleReposicion = new DetalleReposicion();

        detalleReposicion.setCantidad( dto.getCantidad() );

        return detalleReposicion;
    }
}
