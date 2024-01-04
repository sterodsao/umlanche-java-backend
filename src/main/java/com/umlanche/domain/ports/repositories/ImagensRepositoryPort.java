package com.umlanche.domain.ports.repositories;

import com.umlanche.domain.entities.Imagem;

import java.util.List;

public interface ImagensRepositoryPort {
    void createMany(List<Imagem> imagens);
}
