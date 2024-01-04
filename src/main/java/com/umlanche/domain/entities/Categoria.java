package com.umlanche.domain.entities;

public class Categoria {
    private int idCategoria;
    private String dsCategoria;

    public Categoria(){}

    public Categoria(int idCategoria, String dsCategoria) {
        this.idCategoria = idCategoria;
        this.dsCategoria = dsCategoria;
    }

    public int getIdCategoria() {
        return this.idCategoria;
    }

    public String getDsCategoria() {
        return this.dsCategoria;
    }
}
