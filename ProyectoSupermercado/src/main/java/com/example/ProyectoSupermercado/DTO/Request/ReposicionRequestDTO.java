package com.example.ProyectoSupermercado.DTO.Request;

import com.example.ProyectoSupermercado.Entity.Enums.EstadoReposicion;
import com.example.ProyectoSupermercado.Entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReposicionRequestDTO {
    private LocalDateTime fecha;
    private EstadoReposicion estado;
    private Long idUsuario;
}
