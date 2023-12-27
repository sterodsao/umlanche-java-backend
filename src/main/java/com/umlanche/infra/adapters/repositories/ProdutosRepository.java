package com.umlanche.infra.adapters.repositories;

import com.umlanche.domain.entities.Produto;
import com.umlanche.domain.ports.repositories.ProdutosRepositoryPort;
import com.umlanche.infra.adapters.entities.ProdutoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutosRepository implements ProdutosRepositoryPort {
    @Autowired
    private final SpringProdutosRepository springProdutosRepository;

    public ProdutosRepository(SpringProdutosRepository springProdutosRepository) {
        this.springProdutosRepository = springProdutosRepository;
    }

    @Override
    public void create(Produto produto) {
        ProdutoEntity produtoEntity = new ProdutoEntity(produto);
        this.springProdutosRepository.save(produtoEntity);
    }

    @Override
    public List<Produto> getAll() {
        List<ProdutoEntity> entities = this.springProdutosRepository.findAll();

        List<Produto> produtos = new ArrayList<>();

        for(ProdutoEntity entity : entities) {
            produtos.add(entity.toProduto());
        }

        return produtos;
    }

    @Override
    public Produto getById(int idProduto) {
        return null;
    }
}
