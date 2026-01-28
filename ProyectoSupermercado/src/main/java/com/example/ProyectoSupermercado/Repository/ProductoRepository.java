package com.example.ProyectoSupermercado.Repository;

import com.example.ProyectoSupermercado.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    boolean existsByNombre(String nombre);
    Optional<Producto> findById(Long id);
}
