package com.desafioNTT.produtosservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.desafioNTT.produtosservice.model.Produto;
import com.desafioNTT.produtosservice.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public Produto atualizar(Long id, Produto produtoAtualizado) {
        return repository.findById(id)
            .map(p -> {
                p.setNome(produtoAtualizado.getNome());
                p.setPreco(produtoAtualizado.getPreco());
                p.setDescricao(produtoAtualizado.getDescricao());
                
                return repository.save(p);
            })
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
