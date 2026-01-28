package com.example.ProyectoSupermercado.Exception.Producto;

public class ProductoNoExisteException extends RuntimeException {
    public ProductoNoExisteException(String message) {

      super(message);
    }
}
