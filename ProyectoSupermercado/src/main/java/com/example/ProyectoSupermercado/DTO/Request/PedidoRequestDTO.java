package com.example.ProyectoSupermercado.DTO.Request;

import com.example.ProyectoSupermercado.Entity.Enums.EstadoPedido;
import com.example.ProyectoSupermercado.Entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PedidoRequestDTO {
    private Long idUsuario;
    private List<DetallesPedidoRequestDTO> detallesPedidoRequestDTOS;
}
