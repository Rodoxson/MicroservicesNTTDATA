package com.desafioNTT.pedidos_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.desafioNTT.pedidos_service.model.Pedido;
import com.desafioNTT.pedidos_service.repository.PedidoRepository;

@Service
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService (PedidoRepository repository) {
        this.repository = repository;
    }

    public List<Pedido> listarTodos() {
        return repository.findAll();
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Pedido salvar(Pedido pedido) {
        pedido.setStatus("PENDENTE");
        return repository.save(pedido);
    }

    public Pedido atualizar(Long id, Pedido pedidoAtualizado) {
        return repository.findById(id)
            .map(p -> {
                p.setCliente(pedidoAtualizado.getCliente());
                p.setValorTotal(pedidoAtualizado.getValorTotal());
                p.setStatus(pedidoAtualizado.getStatus());
                return repository.save(p);
            })
            .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
