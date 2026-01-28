package com.example.ProyectoSupermercado.Repository;

import com.example.ProyectoSupermercado.Entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
