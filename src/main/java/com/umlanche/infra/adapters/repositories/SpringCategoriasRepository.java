package com.umlanche.infra.adapters.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.umlanche.infra.adapters.entities.CategoriaEntity;

@Repository
public interface SpringCategoriasRepository extends JpaRepository<CategoriaEntity, Integer> {
  @Query("from CategoriaEntity c where c.dsCategoria = ?1")
  public Optional<CategoriaEntity> findCategoriaByDsCategoria(String dsCategoria);
}
