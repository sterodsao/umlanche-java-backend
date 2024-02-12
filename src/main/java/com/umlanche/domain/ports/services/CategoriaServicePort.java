package com.umlanche.domain.ports.services;

import java.util.List;

import com.umlanche.domain.dtos.CategoriaDto;
import com.umlanche.domain.entities.Categoria;

public interface CategoriaServicePort {
  void create(CategoriaDto categoria) throws Exception;
  List<Categoria> findAll();
  Categoria findByid(int idCategoria) throws Exception;
}
