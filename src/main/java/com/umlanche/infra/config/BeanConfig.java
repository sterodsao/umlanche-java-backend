package com.umlanche.infra.config;

import com.umlanche.domain.adapters.services.ProdutoService;
import com.umlanche.domain.ports.repositories.ProdutosRepositoryPort;
import com.umlanche.domain.ports.services.ProdutoServicePort;
import com.umlanche.infra.adapters.entities.ProdutoEntity;
import com.umlanche.infra.adapters.repositories.ProdutosRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

@Configuration
public class BeanConfig {
    @Bean
    ProdutoServicePort produtoService(ProdutosRepositoryPort produtosRepository) {
        return new ProdutoService(produtosRepository);
    }
}
