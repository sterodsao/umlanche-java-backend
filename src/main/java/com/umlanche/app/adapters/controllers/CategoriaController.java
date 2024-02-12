package com.umlanche.app.adapters.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.umlanche.app.adapters.controllers.reponses.CreatedResponse;
import com.umlanche.app.adapters.controllers.reponses.DataResponse;
import com.umlanche.domain.dtos.CategoriaDto;
import com.umlanche.domain.entities.Categoria;
import com.umlanche.domain.ports.services.CategoriaServicePort;
import com.umlanche.infra.response.HttpResponse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("categorias")
public class CategoriaController {
  private final CategoriaServicePort categoriaService;

  public CategoriaController(CategoriaServicePort categoriaService) {
    this.categoriaService = categoriaService;
  }

  @PostMapping
  @ResponseBody ResponseEntity<HttpResponse> handleCreateCategoria(@RequestBody CategoriaDto dto) {
    try {
      this.categoriaService.create(dto);

      return new ResponseEntity<HttpResponse>(new CreatedResponse("Categoria criada com sucesso!"), HttpStatus.CREATED);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @GetMapping
  @ResponseBody ResponseEntity<List<CategoriaDto>> handleGetAllCategorias() {
    try {
      List<Categoria> categorias = this.categoriaService.findAll();
      
      List<CategoriaDto> data = new ArrayList<>();
      for(Categoria categoria : categorias) {
        CategoriaDto dto = new CategoriaDto(categoria.getIdCategoria(), categoria.getDsCategoria());
        data.add(dto);
      }

      return new ResponseEntity<>(data, HttpStatus.OK);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @GetMapping("{idCategoria}")
  @ResponseBody ResponseEntity<DataResponse<CategoriaDto>> handleGetCategoriaById(@PathVariable("idCategoria") int idCategoria) {
    try {
      Categoria categoria = this.categoriaService.findByid(idCategoria);

      return new ResponseEntity<>(new DataResponse<CategoriaDto>(new CategoriaDto(categoria.getIdCategoria(), categoria.getDsCategoria())), HttpStatus.OK);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }
}
