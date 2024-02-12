package com.umlanche.domain.dtos;

public class CategoriaDto {
    private int idCategoria;
    private String dsCategoria;

    public CategoriaDto(){}

    public CategoriaDto(int idCategoria, String dsCategoria) {
        this.idCategoria = idCategoria;
        this.dsCategoria = dsCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getDsCategoria() {
        return dsCategoria;
    }
}
