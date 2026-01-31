package com.example.ProyectoSupermercado.Mapper;

import com.example.ProyectoSupermercado.DTO.Request.DetallesPedidoRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.DetallesPedidoResponseDTO;
import com.example.ProyectoSupermercado.Entity.DetallesPedido;
import com.example.ProyectoSupermercado.Entity.Pedido;
import com.example.ProyectoSupermercado.Entity.Producto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-30T18:42:48-0300",
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

        detallesPedidoResponseDTO.setIdProducto( detallesPedidoProductoId( detallesPedido ) );
        detallesPedidoResponseDTO.setIdPedido( detallesPedidoPedidoId( detallesPedido ) );
        detallesPedidoResponseDTO.setId( detallesPedido.getId() );
        detallesPedidoResponseDTO.setCantidad( detallesPedido.getCantidad() );

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

    private Long detallesPedidoProductoId(DetallesPedido detallesPedido) {
        if ( detallesPedido == null ) {
            return null;
        }
        Producto producto = detallesPedido.getProducto();
        if ( producto == null ) {
            return null;
        }
        Long id = producto.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long detallesPedidoPedidoId(DetallesPedido detallesPedido) {
        if ( detallesPedido == null ) {
            return null;
        }
        Pedido pedido = detallesPedido.getPedido();
        if ( pedido == null ) {
            return null;
        }
        Long id = pedido.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
