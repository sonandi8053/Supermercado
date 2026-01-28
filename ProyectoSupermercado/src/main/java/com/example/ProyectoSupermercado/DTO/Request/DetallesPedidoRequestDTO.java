package com.example.ProyectoSupermercado.DTO.Request;

import com.example.ProyectoSupermercado.Entity.Producto;
import com.example.ProyectoSupermercado.Entity.Reposicion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetallesPedidoRequestDTO {
    private Long idProductoAsociado;
    private Integer cantidad;
}
