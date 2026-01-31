package com.example.ProyectoSupermercado.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetallesReposicionResponseDTO {
    private Long id;
    private Long idReposicion;
    private Long idProducto;
    private Integer cantidad;
}
