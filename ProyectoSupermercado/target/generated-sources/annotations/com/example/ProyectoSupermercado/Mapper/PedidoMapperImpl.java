package com.example.ProyectoSupermercado.Mapper;

import com.example.ProyectoSupermercado.DTO.Request.PedidoRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.PedidoResponseDTO;
import com.example.ProyectoSupermercado.Entity.Pedido;
import com.example.ProyectoSupermercado.Entity.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-30T18:36:26-0300",
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

        pedidoResponseDTO.setIdUsuario( pedidoUsuarioId( pedido ) );
        pedidoResponseDTO.setId( pedido.getId() );
        pedidoResponseDTO.setEstado( pedido.getEstado() );
        pedidoResponseDTO.setFechaCreacion( pedido.getFechaCreacion() );
        pedidoResponseDTO.setTotal( pedido.getTotal() );

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

    private Long pedidoUsuarioId(Pedido pedido) {
        if ( pedido == null ) {
            return null;
        }
        Usuario usuario = pedido.getUsuario();
        if ( usuario == null ) {
            return null;
        }
        Long id = usuario.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
