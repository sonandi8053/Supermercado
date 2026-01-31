package com.example.ProyectoSupermercado.DTO.Response;

import com.example.ProyectoSupermercado.Entity.Enums.TipoMovimiento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovimientoStockResponseDTO {
    private Long id;
    private Long idProducto;
    private Long idUsuario;
    private TipoMovimiento tipoMovimiento;
    private Integer cantidad;
    private LocalDate fecha;
    private String motivo;
}
