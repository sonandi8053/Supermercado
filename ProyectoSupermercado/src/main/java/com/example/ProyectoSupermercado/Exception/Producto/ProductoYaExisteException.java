package com.example.ProyectoSupermercado.Exception.Producto;

public class ProductoYaExisteException extends RuntimeException {
    public ProductoYaExisteException(String message) {
        super(message);
    }
}
