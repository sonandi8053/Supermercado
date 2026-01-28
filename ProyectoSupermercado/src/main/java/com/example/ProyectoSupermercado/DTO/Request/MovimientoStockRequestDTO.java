package com.example.ProyectoSupermercado.DTO.Request;

import com.example.ProyectoSupermercado.Entity.Enums.TipoMovimiento;
import com.example.ProyectoSupermercado.Entity.Producto;
import com.example.ProyectoSupermercado.Entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovimientoStockRequestDTO {
    private Long idProducto;
    private Long idUsuario;
    private TipoMovimiento tipoMovimiento;
    private Integer cantidad;
    private LocalDate fecha;
    private String motivo;
}
