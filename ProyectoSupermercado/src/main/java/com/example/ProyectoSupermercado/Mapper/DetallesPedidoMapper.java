package com.example.ProyectoSupermercado.Mapper;

import com.example.ProyectoSupermercado.DTO.Request.DetallesPedidoRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.DetallesPedidoResponseDTO;
import com.example.ProyectoSupermercado.Entity.DetallesPedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DetallesPedidoMapper {
    @Mapping(source = "producto.id", target = "idProducto")
    @Mapping(source = "pedido.id", target = "idPedido")
    DetallesPedidoResponseDTO toDTO(DetallesPedido detallesPedido);
    DetallesPedido toEntity(DetallesPedidoRequestDTO dto);
}
