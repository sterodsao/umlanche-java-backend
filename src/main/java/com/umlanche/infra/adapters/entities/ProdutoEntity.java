package com.umlanche.infra.adapters.entities;

import com.umlanche.domain.entities.Produto;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "produto")
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idProduto;
    private String dsProduto;
    private String dsResumo;
    private double vlPreco;
    private Date dhCriacao;

    public ProdutoEntity(){}

    public ProdutoEntity(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.dsProduto = produto.getDsProduto();
        this.dsResumo = produto.getDsResumo();
        this.vlPreco = produto.getVlPreco();
        this.dhCriacao = produto.getDhCriacao();
    }

    public Produto toProduto() {
        return new Produto(this.idProduto, this.dsProduto, this.dsResumo, this.vlPreco, this.dhCriacao);
    }

}
