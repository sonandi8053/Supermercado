package com.example.ProyectoSupermercado.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    @Id
    private Long id;
    private Integer cantidadTotal;

    @OneToOne
    @JoinColumn(name = "producto_id", unique = true, nullable = false)
    private Producto producto;

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
    private List<MovimientoStock> movimientosStock = new ArrayList<>();
}
