package com.example.ProyectoSupermercado.Entity;

import com.example.ProyectoSupermercado.Entity.Enums.TipoMovimiento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovimientoStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TipoMovimiento tipoMovimiento;
    private Integer cantidad;
    private LocalDate fecha;
    private String motivo;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;
}
