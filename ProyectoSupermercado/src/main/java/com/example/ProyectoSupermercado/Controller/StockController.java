package com.example.ProyectoSupermercado.Controller;

import com.example.ProyectoSupermercado.DTO.Response.StockResponseDTO;
import com.example.ProyectoSupermercado.Service.Interfaces.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
@CrossOrigin(origins = "http://localhost:5173")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("/disponible/{idProducto}")
    public ResponseEntity<Integer> consultarStockDisponible(@PathVariable Long idProducto) {
        Integer stockDisponible = stockService.consultarStockDisponible(idProducto);
        return ResponseEntity.ok(stockDisponible);
    }

    @PatchMapping("/reservar/{idProducto}")
    public ResponseEntity<Void> reservarStock(
            @PathVariable Long idProducto,
            @RequestParam Integer cantidad,
            @RequestParam Long idUsuario) {
        stockService.reservarStock(idProducto, cantidad, idUsuario);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/incrementar/{idProducto}")
    public ResponseEntity<Void> incrementarStock(
            @PathVariable Long idProducto,
            @RequestParam Integer cantidad,
            @RequestParam Long idUsuario) {
        stockService.incrementarStock(idProducto, cantidad, idUsuario);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/decrementar/{idProducto}")
    public ResponseEntity<Void> decrementarStock(
            @PathVariable Long idProducto,
            @RequestParam Integer cantidad,
            @RequestParam Long idUsuario) {
        stockService.decrementarStock(idProducto, cantidad, idUsuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/critico")
    public ResponseEntity<List<StockResponseDTO>> stockCritico() {
        List<StockResponseDTO> stocksCriticos = stockService.stockCritico();
        return ResponseEntity.ok(stocksCriticos);
    }

    @PatchMapping("/liberar/{idProducto}")
    public ResponseEntity<Void> liberarStock(@PathVariable Long idProducto, @RequestParam Integer cantidad, @RequestParam Long idUsuario) {
        stockService.liberarStock(idProducto, cantidad, idUsuario);
        return ResponseEntity.ok().build();
    }
}
