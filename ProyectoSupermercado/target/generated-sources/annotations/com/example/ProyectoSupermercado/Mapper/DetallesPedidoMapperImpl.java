package com.example.ProyectoSupermercado.Mapper;

import com.example.ProyectoSupermercado.DTO.Request.DetallesPedidoRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.DetallesPedidoResponseDTO;
import com.example.ProyectoSupermercado.Entity.DetallesPedido;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-28T22:01:15-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class DetallesPedidoMapperImpl implements DetallesPedidoMapper {

    @Override
    public DetallesPedidoResponseDTO toDTO(DetallesPedido detallesPedido) {
        if ( detallesPedido == null ) {
            return null;
        }

        DetallesPedidoResponseDTO detallesPedidoResponseDTO = new DetallesPedidoResponseDTO();

        return detallesPedidoResponseDTO;
    }

    @Override
    public DetallesPedido toEntity(DetallesPedidoRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        DetallesPedido detallesPedido = new DetallesPedido();

        detallesPedido.setCantidad( dto.getCantidad() );

        return detallesPedido;
    }
}
