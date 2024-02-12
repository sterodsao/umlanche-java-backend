package com.umlanche.domain.dtos;

import com.umlanche.domain.entities.Categoria;
import com.umlanche.domain.entities.Imagem;
import com.umlanche.domain.entities.Produto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProdutoDto {
    public int idProduto;
    public String dsProduto;
    public String dsResumo;
    public double vlPreco;
    public Date dhCriacao;
    public boolean ehNovidade;
    public CategoriaDto categoriaProduto;
    public List<ImagemDto> produtoImagens;

    public ProdutoDto() {}

    public ProdutoDto(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.dsProduto = produto.getDsProduto();
        this.dsResumo = produto.getDsResumo();
        this.vlPreco = produto.getVlPreco();
        this.dhCriacao = produto.getDhCriacao();
        this.ehNovidade = produto.getEhNovidade();

        Categoria categoriaProduto = produto.getCategoriaProduto();
        this.categoriaProduto = new CategoriaDto(
            categoriaProduto.getIdCategoria(),
            categoriaProduto.getDsCategoria()
        );

        List<Imagem> imagens = produto.getProdutoImagens();
        List<ImagemDto> imagensDto = new ArrayList<>();

        for(Imagem imagem : imagens) {
            imagensDto.add(new ImagemDto(imagem));
        }

        this.produtoImagens = imagensDto;
    }
}
