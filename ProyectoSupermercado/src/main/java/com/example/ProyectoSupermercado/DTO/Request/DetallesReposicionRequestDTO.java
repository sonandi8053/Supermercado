package com.example.ProyectoSupermercado.DTO.Request;

import com.example.ProyectoSupermercado.Entity.Pedido;
import com.example.ProyectoSupermercado.Entity.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetallesReposicionRequestDTO {
    private Long idReposicion;
    private Long idProducto;
    private Integer cantidad;
}
