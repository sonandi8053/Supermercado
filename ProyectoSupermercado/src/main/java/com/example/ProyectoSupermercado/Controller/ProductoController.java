package com.example.ProyectoSupermercado.Controller;

import com.example.ProyectoSupermercado.DTO.Request.ProductoRequestDTO;
import com.example.ProyectoSupermercado.DTO.Response.ProductoResponseDTO;
import com.example.ProyectoSupermercado.Service.Interfaces.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<ProductoResponseDTO> crearProducto(@RequestBody ProductoRequestDTO dto) {
        ProductoResponseDTO productoCreado = productoService.crearProducto(dto);
        return new ResponseEntity<>(productoCreado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editarProducto(@PathVariable Long id, @RequestBody ProductoRequestDTO dto) {
        productoService.editarProducto(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> listarProductos() {
        List<ProductoResponseDTO> productos = productoService.listarProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @PatchMapping("/{id}/activo")
    public ResponseEntity<Void> modificarActivo(@PathVariable Long id) {
        productoService.modificarActivo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
