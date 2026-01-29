package com.example.ProyectoSupermercado.Mapper;

import com.example.ProyectoSupermercado.DTO.Request.PedidoRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.PedidoResponseDTO;
import com.example.ProyectoSupermercado.Entity.Pedido;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-28T22:01:15-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class PedidoMapperImpl implements PedidoMapper {

    @Override
    public PedidoResponseDTO toDTO(Pedido pedido) {
        if ( pedido == null ) {
            return null;
        }

        PedidoResponseDTO pedidoResponseDTO = new PedidoResponseDTO();

        return pedidoResponseDTO;
    }

    @Override
    public Pedido toEntity(PedidoRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Pedido pedido = new Pedido();

        return pedido;
    }
}
