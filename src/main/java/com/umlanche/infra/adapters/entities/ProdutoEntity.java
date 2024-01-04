package com.umlanche.infra.adapters.entities;

import com.umlanche.domain.entities.Categoria;
import com.umlanche.domain.entities.Imagem;
import com.umlanche.domain.entities.Produto;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaEntity categoriaProduto;

    @OneToMany(mappedBy = "produto")
    private List<ImagemEntity> produtoImagens;

    public ProdutoEntity() {
    }

    public ProdutoEntity(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.dsProduto = produto.getDsProduto();
        this.dsResumo = produto.getDsResumo();
        this.vlPreco = produto.getVlPreco();
        this.dhCriacao = produto.getDhCriacao();

        Categoria categoriaProduto = produto.getCategoriaProduto();
        CategoriaEntity categoriaEntity =
            new CategoriaEntity(categoriaProduto.getIdCategoria(),
                categoriaProduto.getDsCategoria());

        this.categoriaProduto = categoriaEntity;
        this.produtoImagens = new ArrayList<>();
    }

    public Produto toProduto() {
        List<ImagemEntity> imagensEntity = this.produtoImagens;
        List<Imagem> imagens = new ArrayList<>();

        for(ImagemEntity entity : imagensEntity) {
            imagens.add(entity.toImagem());
        }

        return new Produto(this.idProduto, this.dsProduto, this.dsResumo,
            this.vlPreco, this.dhCriacao,
            new Categoria(this.categoriaProduto.getIdCategoria(),
                this.categoriaProduto.getDsCategoria()),
            imagens
        );
    }

    public void setProdutoImagens(List<Imagem> imagens) {
        List<ImagemEntity> imagensEntity = new ArrayList<>();

        for(Imagem imagem : imagens) {
            imagensEntity.add(new ImagemEntity(imagem));
        }

        this.produtoImagens = imagensEntity;
    }
}
