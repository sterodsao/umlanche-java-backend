package com.umlanche.infra.adapters.repositories.mappers;

import java.util.ArrayList;
import java.util.List;

import com.umlanche.domain.dtos.ImagemDto;
import com.umlanche.domain.dtos.ProdutoDto;
import com.umlanche.domain.entities.Imagem;
import com.umlanche.domain.entities.Produto;
import com.umlanche.infra.adapters.entities.CategoriaEntity;
import com.umlanche.infra.adapters.entities.ImagemEntity;
import com.umlanche.infra.adapters.entities.ProdutoEntity;

public class ProdutoMapper {
  public static final Produto toDomain(ProdutoEntity raw) {
    List<Imagem> imagens = new ArrayList<>();
    for(ImagemEntity imagem : raw.getProdutoImagens()) {
      imagens.add(new Imagem(imagem.getIdImagem(), imagem.getDsUrl(), imagem.getDsResumo(), imagem.getNrImagem(), imagem.getEhPrincipal()));
    }

    return new Produto(raw.getIdProduto(), raw.getDsProduto(), raw.getDsResumo(), raw.getVlPreco(), raw.getDhCriacao(), CategoriaMapper.toDomain(raw.getCategoriaProduto()), imagens);
  }

  public static final Produto toDomain(ProdutoDto dto) {
    List<Imagem> imagens = new ArrayList<>();
    for(ImagemDto imagem : dto.produtoImagens) {
      imagens.add(ImagemMapper.toDomain(imagem));
    }

    return new Produto(dto.idProduto, dto.dsProduto, dto.dsResumo, dto.vlPreco, dto.dhCriacao, CategoriaMapper.toDomain(dto.categoriaProduto), imagens);
  }

  public static final ProdutoEntity toDatabase(Produto entity) {
    List<ImagemEntity> imagens = new ArrayList<>();
    for(Imagem imagem : entity.getProdutoImagens()) {
      imagens.add(ImagemMapper.toDatabase(imagem));
    }

    CategoriaEntity categoria = CategoriaMapper.toDatabase(entity.getCategoriaProduto());

    return new ProdutoEntity(entity.getIdProduto(), entity.getDsProduto(), entity.getDsResumo(), entity.getVlPreco(), entity.getDhCriacao(), imagens, categoria);
  }
}
