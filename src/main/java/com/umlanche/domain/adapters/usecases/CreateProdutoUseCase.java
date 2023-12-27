package com.umlanche.domain.adapters.usecases;

import com.umlanche.domain.dtos.ProdutoDto;
import com.umlanche.domain.entities.Produto;
import com.umlanche.domain.ports.repositories.ProdutosRepositoryPort;

public class CreateProdutoUseCase {
    private final ProdutosRepositoryPort produtosRepository;

    public CreateProdutoUseCase(ProdutosRepositoryPort produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    public void execute(ProdutoDto produto) {
        Produto newProduto = new Produto(produto);

        this.produtosRepository.create(newProduto);
    }
}
