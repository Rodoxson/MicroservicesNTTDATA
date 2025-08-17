package com.desafioNTT.produtosservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafioNTT.produtosservice.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Métodos adicionais de consulta podem ser definidos aqui, se necessário
}
