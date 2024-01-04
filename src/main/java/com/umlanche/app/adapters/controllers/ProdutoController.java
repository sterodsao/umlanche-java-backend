package com.umlanche.app.adapters.controllers;

import com.umlanche.app.adapters.controllers.reponses.CreatedResponse;
import com.umlanche.domain.dtos.ProdutoDto;
import com.umlanche.domain.entities.Produto;
import com.umlanche.domain.ports.services.ProdutoServicePort;
import com.umlanche.infra.response.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    private final ProdutoServicePort produtoServicePort;

    public ProdutoController(ProdutoServicePort produtoServicePort){
        this.produtoServicePort = produtoServicePort;
    }

    @PostMapping
    @ResponseBody ResponseEntity<HttpResponse> handleCreateProduto(@RequestBody ProdutoDto body) {
        try{
            this.produtoServicePort.createProduto(body);

            return new ResponseEntity<>(new CreatedResponse("Produto criado com sucesso!"), HttpStatus.CREATED);
        }catch(Exception e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping
    @ResponseBody List<ProdutoDto> handleGetAllProdutos() {
        List<ProdutoDto> dtos = new ArrayList<>();

        try {
            List<Produto> produtos = this.produtoServicePort.getAll();

            for(Produto produto : produtos) {
                dtos.add(new ProdutoDto(produto));
            }
        }catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

        return dtos;
    }

    @GetMapping("{idProduto}")
    @ResponseBody Optional<ProdutoDto> handleFindByid(@PathVariable int idProduto) {
        try{
            Produto produto = this.produtoServicePort.getById(idProduto);

            return Optional.of(new ProdutoDto(produto));
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado");
        }
    }
}
