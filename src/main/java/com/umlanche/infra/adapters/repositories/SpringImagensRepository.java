package com.umlanche.infra.adapters.repositories;

import com.umlanche.infra.adapters.entities.ImagemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringImagensRepository extends JpaRepository<ImagemEntity, Integer> {
}
