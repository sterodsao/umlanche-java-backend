package com.umlanche.domain.dtos;

import com.umlanche.domain.entities.Imagem;

public class ImagemDto {
    public int idImagem;
    public String dsUrl;
    public String dsResumo;
    public int nrImagem;
    public boolean ehPrincipal;

    public ImagemDto() {
    }

    public ImagemDto(Imagem imagem) {
        this.idImagem = imagem.getIdImagem();
        this.dsUrl = imagem.getDsUrl();
        this.dsResumo = imagem.getDsResumo();
        this.nrImagem = imagem.getNrImagem();
        this.ehPrincipal = imagem.getEhPrincipal();
    }

    public Imagem toImagem() {
        return new Imagem(this.idImagem, this.dsUrl, this.dsResumo,
            this.nrImagem, this.ehPrincipal);
    }
}
