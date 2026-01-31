package com.example.ProyectoSupermercado.DTO.Response;

import com.example.ProyectoSupermercado.Entity.Enums.EstadoPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PedidoResponseDTO {
    private Long id;
    private Long idUsuario;
    private EstadoPedido estado;
    private LocalDate fechaCreacion;
    private Integer total;
}
