package com.umlanche.domain.adapters.services;

import com.umlanche.domain.dtos.ProdutoDto;
import com.umlanche.domain.entities.Produto;
import com.umlanche.domain.ports.repositories.ProdutosRepositoryPort;
import com.umlanche.domain.ports.services.ProdutoServicePort;

import java.util.List;

public class ProdutoService implements ProdutoServicePort {
    private final ProdutosRepositoryPort produtosRepository;

    public ProdutoService(ProdutosRepositoryPort produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    @Override
    public void createProduto(ProdutoDto dto) {
        this.produtosRepository.create(dto.toProduto());
    }

    @Override
    public List<Produto> getAll() {
        return this.produtosRepository.getAll();
    }

    @Override
    public Produto getById(int idProduto) {
        return this.produtosRepository.getById(idProduto);
    }
}
