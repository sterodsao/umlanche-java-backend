package com.umlanche.infra.adapters.repositories.mappers;

import com.umlanche.domain.dtos.CategoriaDto;
import com.umlanche.domain.entities.Categoria;
import com.umlanche.infra.adapters.entities.CategoriaEntity;

public class CategoriaMapper {
  public static final CategoriaEntity toDatabase(Categoria categoria) {
    return new CategoriaEntity(categoria.getIdCategoria(), categoria.getDsCategoria());
  }

  public static final Categoria toDomain(CategoriaEntity raw) {
    return new Categoria(raw.getIdCategoria(), raw.getDsCategoria());
  }

  public static final Categoria toDomain(CategoriaDto dto) {
    return new Categoria(dto.getIdCategoria(), dto.getDsCategoria());
  }
}
