package com.umlanche.domain.dtos;

import com.umlanche.domain.entities.Produto;

import java.util.Date;

public class ProdutoDto {
    public int idProduto;
    public String dsProduto;
    public String dsResumo;
    public double vlPreco;
    public Date dhCriacao;

    public ProdutoDto(){}

    public ProdutoDto(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.dsProduto = produto.getDsProduto();
        this.dsResumo = produto.getDsResumo();
        this.vlPreco = produto.getVlPreco();
        this.dhCriacao = produto.getDhCriacao();
    }
}
