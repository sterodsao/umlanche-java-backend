package com.umlanche.infra.adapters.repositories;

import com.umlanche.domain.entities.Imagem;
import com.umlanche.domain.entities.Produto;
import com.umlanche.domain.ports.repositories.ImagensRepositoryPort;
import com.umlanche.domain.ports.repositories.ProdutosRepositoryPort;
import com.umlanche.infra.adapters.entities.ImagemEntity;
import com.umlanche.infra.adapters.entities.ProdutoEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProdutosRepository implements ProdutosRepositoryPort {
    private final SpringProdutosRepository springProdutosRepository;
    private final ImagensRepositoryPort imagensRepositoryPort;

    public ProdutosRepository(SpringProdutosRepository springProdutosRepository, ImagensRepositoryPort imagensRepositoryPort) {
        this.springProdutosRepository = springProdutosRepository;
        this.imagensRepositoryPort = imagensRepositoryPort;
    }

    @Override
    @Transactional
    public void create(Produto produto) {
        ProdutoEntity produtoEntity = new ProdutoEntity(produto);

        ProdutoEntity entity = this.springProdutosRepository.save(produtoEntity);

        List<Imagem> imagens = produto.getProdutoImagens();
        if (imagens.isEmpty()) return;

        this.springProdutosRepository.flush();

        this.saveImages(entity.toProduto(), imagens);
    }

    @Override
    public List<Produto> getAll() {
        List<ProdutoEntity> entities = this.springProdutosRepository.findAll();

        List<Produto> produtos = new ArrayList<>();

        for (ProdutoEntity entity : entities) {
            produtos.add(entity.toProduto());
        }

        return produtos;
    }

    @Override
    public Produto getById(int idProduto) {
        Optional<ProdutoEntity> entity =
            this.springProdutosRepository.findById(idProduto);

        return entity.map(ProdutoEntity::toProduto).orElse(null);
    }

    private void saveImages(Produto produto, List<Imagem> imagens) {
        for (Imagem imagem : imagens) {
            imagem.setProduto(produto);
        }

        this.imagensRepositoryPort.createMany(imagens);
    }
}
