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
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private Integer precio;
    private Boolean esActivo;

    @OneToOne(mappedBy = "producto", cascade = CascadeType.ALL)
    private Stock stock;

    @OneToMany(mappedBy = "producto")
    private List<DetallesPedido> detalles = new ArrayList<>();

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<DetalleReposicion> detallesReposicion = new ArrayList<>();
}
