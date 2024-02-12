package com.umlanche.infra.adapters.entities;

import com.umlanche.domain.entities.Imagem;
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

    public ProdutoEntity(int idProduto, String dsProduto, String dsResumo, double vlPreco, Date dhCriacao, List<ImagemEntity> produtoImagens, CategoriaEntity produtoCategoria) {
        this.idProduto = idProduto;
        this.dsProduto = dsProduto;
        this.dsResumo = dsResumo;
        this.vlPreco = vlPreco;
        this.dhCriacao = dhCriacao;
        this.produtoImagens = produtoImagens;
        this.categoriaProduto = produtoCategoria;
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
    public CategoriaEntity getCategoriaProduto() {
        return this.categoriaProduto;
    }
    public List<ImagemEntity> getProdutoImagens() {
        return this.produtoImagens;
    }

    public void setProdutoImagens(List<Imagem> imagens) {
        List<ImagemEntity> imagensEntity = new ArrayList<>();

        for(Imagem imagem : imagens) {
            imagensEntity.add(new ImagemEntity(imagem));
        }

        this.produtoImagens = imagensEntity;
    }
}
