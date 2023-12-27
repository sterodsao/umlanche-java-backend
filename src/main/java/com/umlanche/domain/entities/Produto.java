package com.umlanche.domain.entities;

import com.umlanche.domain.dtos.ProdutoDto;

import java.time.Duration;
import java.util.Date;

public class Produto {
    private int idProduto;
    private String dsProduto;
    private String dsResumo;
    private double vlPreco;
    private Date dhCriacao;

    public Produto(){}
    public Produto(int idProduto, String dsProduto, String dsResumo, double vlPreco, Date dhCriacao) {
        this.idProduto = idProduto;
        this.dsProduto = dsProduto;
        this.dsResumo = dsResumo;
        this.vlPreco = vlPreco;
        this.dhCriacao = dhCriacao != null ? dhCriacao : new Date();
    }

    public Produto(ProdutoDto dto) {
        this.idProduto = dto.idProduto;
        this.dsProduto = dto.dsProduto;
        this.dsResumo = dto.dsResumo;
        this.vlPreco = dto.vlPreco;
        this.dhCriacao = dto.dhCriacao != null ? dto.dhCriacao : new Date();
    }

    public int getIdProduto() {
        return this.idProduto;
    }

    public String getDsProduto() {
        return this.dsProduto;
    }

    public String getDsResumo() {
        return this.dsResumo;
    }

    public double getVlPreco() {
        return this.vlPreco;
    }

    public Date getDhCriacao() {
        return this.dhCriacao;
    }
    public boolean getEhNovidade() {
        return Duration.between(new Date().toInstant(), this.dhCriacao.toInstant()).toDays() < 5;
    }
}
