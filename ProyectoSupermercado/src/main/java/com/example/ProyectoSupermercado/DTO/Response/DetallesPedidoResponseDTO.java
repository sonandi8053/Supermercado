package com.example.ProyectoSupermercado.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetallesPedidoResponseDTO {
    private Long id;
    private Long idPedido;
    private Long idProducto;
    private Integer cantidad;
}
