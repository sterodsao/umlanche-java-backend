package com.umlanche.domain.entities;

public class Imagem {
    private int idImagem;
    private String dsUrl;
    private String dsResumo;
    private int nrImagem;
    private boolean ehPrincipal;
    private Produto produto;

    public Imagem() {
    }

    public Imagem(int idImagem, String dsUrl, String dsResumo, int nrImagem,
                  boolean ehPrincipal) {
        this.idImagem = idImagem;
        this.dsUrl = dsUrl;
        this.dsResumo = dsResumo;
        this.nrImagem = nrImagem;
        this.ehPrincipal = ehPrincipal;
    }

    public int getIdImagem() {
        return this.idImagem;
    }

    public String getDsUrl() {
        return this.dsUrl;
    }

    public String getDsResumo() {
        return this.dsResumo;
    }

    public int getNrImagem() {
        return this.nrImagem;
    }

    public boolean getEhPrincipal() {
        return this.ehPrincipal;
    }
    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}