package com.example.ProyectoSupermercado.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockResponseDTO {
    private Long id;
    private Long idProducto;
    private Integer cantidadTotal;
}
