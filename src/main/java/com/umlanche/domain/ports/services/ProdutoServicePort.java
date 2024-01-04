package com.umlanche.domain.ports.services;

import com.umlanche.domain.dtos.ProdutoDto;
import com.umlanche.domain.entities.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoServicePort {
    void createProduto(ProdutoDto produto);
    List<Produto> getAll();
    Produto getById(int idProduto);
}
