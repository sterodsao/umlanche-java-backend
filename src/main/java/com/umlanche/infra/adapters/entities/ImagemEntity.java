package com.umlanche.infra.adapters.entities;

import com.umlanche.domain.entities.Imagem;
import com.umlanche.infra.adapters.repositories.mappers.ProdutoMapper;

import jakarta.persistence.*;

@Entity
@Table(name = "imagem")
public class ImagemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idImagem;
    private String dsUrl;
    private String dsResumo;
    private int nrImagem;
    private boolean ehPrincipal;
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private ProdutoEntity produto;

    public ImagemEntity() {
    }

    public ImagemEntity(int idImagem, String dsUrl, String dsResumo,
                        int nrImagem, boolean ehPrincipal) {
        this.idImagem = idImagem;
        this.dsUrl = dsUrl;
        this.dsResumo = dsResumo;
        this.nrImagem = nrImagem;
        this.ehPrincipal = ehPrincipal;
    }

    public ImagemEntity(Imagem imagem) {
        this.idImagem = imagem.getIdImagem();
        this.dsUrl = imagem.getDsUrl();
        this.dsResumo = imagem.getDsResumo();
        this.nrImagem = imagem.getNrImagem();
        this.ehPrincipal = imagem.getEhPrincipal();
        this.produto = ProdutoMapper.toDatabase(imagem.getProduto());
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

    public Imagem toImagem() {
        return new Imagem(this.idImagem, this.dsUrl, this.dsResumo,
            this.nrImagem, this.ehPrincipal);
    }
}
