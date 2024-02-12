package com.umlanche.domain.ports.repositories;

import java.util.List;

import com.umlanche.domain.entities.Categoria;

public interface CategoriasRepositoryPort {
  void create(Categoria categoria) throws Exception;
  List<Categoria> findAll();
  Categoria findById(int idCategoria);
}
