package com.desafioNTT.pedidos_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.desafioNTT.pedidos_service.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // aqui você pode adicionar consultas personalizadas se quiser
}

