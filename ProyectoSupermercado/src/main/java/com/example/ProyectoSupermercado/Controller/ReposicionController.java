package com.example.ProyectoSupermercado.Controller;

import com.example.ProyectoSupermercado.DTO.Request.ReposicionRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.ReposicionResponseDTO;
import com.example.ProyectoSupermercado.Service.Interfaces.ReposicionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reposicion")
@CrossOrigin(origins = "http://localhost:5173")
public class ReposicionController {
    @Autowired
    private ReposicionService reposicionService;

    @PostMapping
    public ResponseEntity<ReposicionResponseDTO> crear(@RequestBody ReposicionRequestDTO dto) {
        ReposicionResponseDTO reposicionCreada = reposicionService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(reposicionCreada);
    }

    @PatchMapping("/{idReposicion}/estado")
    public ResponseEntity<Void> cambiarEstado(@PathVariable Long idReposicion) {
        reposicionService.cambiarEstado(idReposicion);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ReposicionResponseDTO>> verReposiciones() {
        List<ReposicionResponseDTO> reposiciones = reposicionService.verReposiciones();
        return ResponseEntity.ok(reposiciones);
    }

    @GetMapping("/reponedor/{idReponedor}")
    public ResponseEntity<List<ReposicionResponseDTO>> verReposicionesPorReponedor(@PathVariable Long idReponedor) {
        List<ReposicionResponseDTO> reposiciones = reposicionService.verReposicionesPorReponedor(idReponedor);
        return ResponseEntity.ok(reposiciones);
    }
}
