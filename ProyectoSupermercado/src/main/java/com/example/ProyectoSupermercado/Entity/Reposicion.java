package com.example.ProyectoSupermercado.Entity;

import com.example.ProyectoSupermercado.Entity.Enums.EstadoReposicion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reposicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fecha;
    private EstadoReposicion estado;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "reposicion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleReposicion> detallesReposicion = new ArrayList<>();
}
