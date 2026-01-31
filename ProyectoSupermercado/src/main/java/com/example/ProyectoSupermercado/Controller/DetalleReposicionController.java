package com.example.ProyectoSupermercado.Controller;

import com.example.ProyectoSupermercado.DTO.Request.DetallesReposicionRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.DetallesReposicionResponseDTO;
import com.example.ProyectoSupermercado.Service.Interfaces.DetallesReposicionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalleReposicion")
@CrossOrigin(origins = "http://localhost:5173")
public class DetalleReposicionController {

    @Autowired
    private DetallesReposicionService detallesReposicionService;

    @GetMapping("/reposicion/{idReposicion}")
    public ResponseEntity<List<DetallesReposicionResponseDTO>> obtenerDetallesPorReposicion(@PathVariable Long idReposicion) {
        List<DetallesReposicionResponseDTO> detalles = detallesReposicionService.obtenerDetallesPorReposicion(idReposicion);
        return ResponseEntity.ok(detalles);
    }
}
