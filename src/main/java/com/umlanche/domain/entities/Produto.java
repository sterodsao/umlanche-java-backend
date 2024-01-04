package com.umlanche.domain.entities;

import com.umlanche.domain.dtos.ProdutoDto;

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Produto {
    private int idProduto;
    private String dsProduto;
    private String dsResumo;
    private double vlPreco;
    private Date dhCriacao;
    private Categoria categoriaProduto;
    private List<Imagem> produtoImagens;

    public Produto() {
    }

    public Produto(int idProduto, String dsProduto, String dsResumo,
                   double vlPreco, Date dhCriacao, Categoria categoriaProduto, List<Imagem> produtoImagens) {
        this.idProduto = idProduto;
        this.dsProduto = dsProduto;
        this.dsResumo = dsResumo;
        this.vlPreco = vlPreco;
        this.dhCriacao = dhCriacao != null ? dhCriacao : new Date();
        this.categoriaProduto = categoriaProduto;
        this.produtoImagens = produtoImagens;
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

    public Categoria getCategoriaProduto() {
        return this.categoriaProduto;
    }

    public List<Imagem> getProdutoImagens() {
        return this.produtoImagens;
    }

    public void setProdutoImagens(List<Imagem> imagens) {
        this.produtoImagens = imagens;
    }


    public boolean getEhNovidade() {
        Date today = new Date();
        Duration dateDifference = Duration.between(today.toInstant(),
            this.dhCriacao.toInstant());

        return dateDifference.toDays() < 5;
    }
}
