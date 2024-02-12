package com.umlanche.infra.adapters.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.umlanche.domain.entities.Categoria;
import com.umlanche.domain.ports.repositories.CategoriasRepositoryPort;
import com.umlanche.infra.adapters.entities.CategoriaEntity;
import com.umlanche.infra.adapters.repositories.mappers.CategoriaMapper;

@Component
public class CategoriasRepository implements CategoriasRepositoryPort {
  private final SpringCategoriasRepository springCategoriasRepository;

  public CategoriasRepository(SpringCategoriasRepository springCategoriasRepository) {
    this.springCategoriasRepository = springCategoriasRepository;
  }

  @Override
  public void create(Categoria categoria) throws Exception {
    Optional<CategoriaEntity> raw = this.springCategoriasRepository.findCategoriaByDsCategoria(categoria.getDsCategoria());
    if(raw.isPresent()) throw new Exception("Categoria já existe");

    CategoriaEntity data = CategoriaMapper.toDatabase(categoria);

    this.springCategoriasRepository.save(data);
  }

  @Override
  public List<Categoria> findAll() {
    List<CategoriaEntity> entities = this.springCategoriasRepository.findAll();

    List<Categoria> categorias = new ArrayList<>();
    for(CategoriaEntity entity : entities ){
      categorias.add(CategoriaMapper.toDomain(entity));
    }

    return categorias;
  }

  @Override
  public Categoria findById(int idCategoria) {
    Optional<CategoriaEntity> categoria = this.springCategoriasRepository.findById(idCategoria);
    if(categoria.isEmpty()) return null;

    return CategoriaMapper.toDomain(categoria.get());
  }
  
}
