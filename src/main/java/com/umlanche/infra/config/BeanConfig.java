package com.umlanche.infra.config;

import com.umlanche.domain.adapters.services.CategoriaService;
import com.umlanche.domain.adapters.services.ProdutoService;
import com.umlanche.domain.ports.repositories.CategoriasRepositoryPort;
import com.umlanche.domain.ports.repositories.ProdutosRepositoryPort;
import com.umlanche.domain.ports.services.CategoriaServicePort;
import com.umlanche.domain.ports.services.ProdutoServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    ProdutoServicePort produtoService(ProdutosRepositoryPort produtosRepository) {
        return new ProdutoService(produtosRepository);
    }

    @Bean
    CategoriaServicePort categoriaService(CategoriasRepositoryPort categoriasRepository) {
        return new CategoriaService(categoriasRepository);
    }
}
