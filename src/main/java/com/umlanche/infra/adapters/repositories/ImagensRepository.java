package com.umlanche.infra.adapters.repositories;

import com.umlanche.domain.entities.Imagem;
import com.umlanche.domain.ports.repositories.ImagensRepositoryPort;
import com.umlanche.infra.adapters.entities.ImagemEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ImagensRepository implements ImagensRepositoryPort {
    private final SpringImagensRepository springImagensRepository;

    public ImagensRepository(SpringImagensRepository springImagensRepository) {
        this.springImagensRepository = springImagensRepository;
    }

    @Override
    public void createMany(List<Imagem> imagens) {
        List<ImagemEntity> entities = new ArrayList<>();
        for(Imagem imagem : imagens) {
            entities.add(new ImagemEntity(imagem));
        }

        this.springImagensRepository.saveAll(entities);
    }
}
