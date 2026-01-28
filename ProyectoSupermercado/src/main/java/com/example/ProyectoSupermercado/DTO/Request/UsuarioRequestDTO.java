package com.example.ProyectoSupermercado.DTO.Request;

import com.example.ProyectoSupermercado.Entity.Enums.Rol;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioRequestDTO {
    private String nombre;
    private String email;
    private String contrasenia;
    private LocalDate fecha_nac;
    private Rol rol;
}
