package com.example.ProyectoSupermercado.Repository;

import com.example.ProyectoSupermercado.Entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
