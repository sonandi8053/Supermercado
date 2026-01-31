package com.example.ProyectoSupermercado.Controller;

import com.example.ProyectoSupermercado.DTO.Response.MovimientoStockResponseDTO;
import com.example.ProyectoSupermercado.Service.Interfaces.MovimientoStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movimientoStock")
@CrossOrigin(origins = "http://localhost:5173")
public class MovimientoStockController {
    @Autowired
    private MovimientoStockService movimientoStockService;

    @GetMapping("/mostrar")
    public ResponseEntity<List<MovimientoStockResponseDTO>> verMovimientos() {
        List<MovimientoStockResponseDTO> movimientos = movimientoStockService.verMovimientos();
        return ResponseEntity.ok(movimientos);
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<List<MovimientoStockResponseDTO>> verMovimientosPorProducto(@PathVariable Long id) {
        List<MovimientoStockResponseDTO> movimientos = movimientoStockService.verMovimientosPorProducto(id);
        return ResponseEntity.ok(movimientos);
    }
}
