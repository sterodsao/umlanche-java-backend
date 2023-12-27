package com.umlanche.app.adapters.controllers;

import com.umlanche.domain.dtos.ProdutoDto;
import com.umlanche.domain.entities.Produto;
import com.umlanche.domain.ports.services.ProdutoServicePort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    private final ProdutoServicePort produtoServicePort;

    public ProdutoController(ProdutoServicePort produtoServicePort){
        this.produtoServicePort = produtoServicePort;
    }

    @PostMapping
    void handleCreateProduto(@RequestBody ProdutoDto body) {
        try{
            this.produtoServicePort.createProduto(body);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @GetMapping
    List<ProdutoDto> handleGetAllProdutos() {
        List<ProdutoDto> dtos = new ArrayList<>();

        try {
            List<Produto> produtos = this.produtoServicePort.getAll();

            for(Produto produto : produtos) {
                dtos.add(new ProdutoDto(produto));
            }

        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return dtos;
    }
}
