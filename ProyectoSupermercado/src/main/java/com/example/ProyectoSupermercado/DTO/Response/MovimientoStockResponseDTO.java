package com.example.ProyectoSupermercado.DTO.Response;

import com.example.ProyectoSupermercado.Entity.Enums.TipoMovimiento;

import java.time.LocalDate;

public class MovimientoStockResponseDTO {
    private Long id;
    private Long idProducto;
    private Long idUsuario;
    private TipoMovimiento tipoMovimiento;
    private Integer cantidad;
    private LocalDate fecha;
    private String motivo;
}
