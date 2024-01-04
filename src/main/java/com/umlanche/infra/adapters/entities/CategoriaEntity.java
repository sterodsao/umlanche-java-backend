package com.umlanche.infra.adapters.entities;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idCategoria;
    private String dsCategoria;
    @OneToMany(mappedBy = "categoriaProduto")
    private List<ProdutoEntity> produtos;

    public CategoriaEntity(){}

    public CategoriaEntity(int idCategoria, String dsCategoria) {
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
