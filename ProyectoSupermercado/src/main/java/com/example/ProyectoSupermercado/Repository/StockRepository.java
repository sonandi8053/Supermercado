package com.example.ProyectoSupermercado.Repository;

import com.example.ProyectoSupermercado.Entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {
    @Query (
            value = "Select * from Stock where cantidadTotal <= 5",
            nativeQuery = true
    )
    List<Stock> stockCriticos ();
}
