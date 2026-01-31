package com.example.ProyectoSupermercado.Controller;

import com.example.ProyectoSupermercado.DTO.Response.DetallesPedidoResponseDTO;
import com.example.ProyectoSupermercado.Service.Interfaces.DetallesPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detallePedido")
@CrossOrigin(origins = "http://localhost:5173")
public class DetallesPedidoController {
    @Autowired
    private DetallesPedidoService detallesPedidoService;

    @GetMapping("/pedido/{idPedido}")
    public ResponseEntity<List<DetallesPedidoResponseDTO>> obtenerDetallesPorPedido(@PathVariable Long idPedido) {
        List<DetallesPedidoResponseDTO> detalles = detallesPedidoService.obtenerDetallesPorPedido(idPedido);
        return ResponseEntity.ok(detalles);
    }
}
