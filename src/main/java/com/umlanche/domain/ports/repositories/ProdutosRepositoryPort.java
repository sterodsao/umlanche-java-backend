package com.umlanche.domain.ports.repositories;

import com.umlanche.domain.entities.Imagem;
import com.umlanche.domain.entities.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutosRepositoryPort {
    void create(Produto produto);
    List<Produto> getAll();
    Produto getById(int idProduto);
}
