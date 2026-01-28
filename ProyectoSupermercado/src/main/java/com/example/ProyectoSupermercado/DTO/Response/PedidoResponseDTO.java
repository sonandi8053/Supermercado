package com.example.ProyectoSupermercado.DTO.Response;

import com.example.ProyectoSupermercado.Entity.Enums.EstadoPedido;

import java.time.LocalDate;

public class PedidoResponseDTO {
    private Long id;
    private Long idUsuario;
    private EstadoPedido estado;
    private LocalDate fechaCreacion;
    private Integer total;
}
