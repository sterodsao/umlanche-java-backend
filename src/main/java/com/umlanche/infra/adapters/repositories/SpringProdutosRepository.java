package com.umlanche.infra.adapters.repositories;

import com.umlanche.infra.adapters.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringProdutosRepository extends JpaRepository<ProdutoEntity, Integer> {
}