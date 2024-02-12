package com.umlanche.domain.adapters.services;

import java.util.List;

import com.umlanche.domain.dtos.CategoriaDto;
import com.umlanche.domain.entities.Categoria;
import com.umlanche.domain.ports.repositories.CategoriasRepositoryPort;
import com.umlanche.domain.ports.services.CategoriaServicePort;
import com.umlanche.infra.adapters.repositories.mappers.CategoriaMapper;

public class CategoriaService implements CategoriaServicePort {
  private final CategoriasRepositoryPort categoriasRepository;

  public CategoriaService(CategoriasRepositoryPort categoriasRepository){
    this.categoriasRepository = categoriasRepository;
  }

  @Override
  public void create(CategoriaDto categoria) throws Exception {
    this.categoriasRepository.create(CategoriaMapper.toDomain(categoria));
  }

  @Override
  public List<Categoria> findAll() {
    List<Categoria> categorias = this.categoriasRepository.findAll();

    return categorias;
  }

  @Override
  public Categoria findByid(int idCategoria) throws Exception {
    Categoria categoria = this.categoriasRepository.findById(idCategoria);
    if(categoria == null) throw new Exception("Produto não encontrado!");

    return categoria;
  }
  
}
