package com.example.ProyectoSupermercado.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductoRequestDTO {
    private String nombre;
    private String descripcion;
    private Integer precio;
    private Boolean esActivo;
}
