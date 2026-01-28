package com.example.ProyectoSupermercado.Exception.Usuario;

public class UsuarioYaExiste extends RuntimeException {
    public UsuarioYaExiste(String message) {
        super(message);
    }
}
