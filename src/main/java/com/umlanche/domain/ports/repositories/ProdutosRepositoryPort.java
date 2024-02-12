package com.umlanche.domain.ports.repositories;

import com.umlanche.domain.entities.Produto;

import java.util.List;

public interface ProdutosRepositoryPort {
    void create(Produto produto);
    List<Produto> getAll();
    Produto getById(int idProduto);
}
