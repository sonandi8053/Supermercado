package com.example.ProyectoSupermercado.Exception.Pedido;

public class PedidoNoExisteException extends RuntimeException {
    public PedidoNoExisteException(String message) {
        super(message);
    }
}
