package br.com.estoque.model;

import br.com.estoque.exception.CampoObrigatorioException;
import br.com.estoque.exception.InformacaoInvalidaException;

public class Produto {

    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidadeMinima;
    private Integer estoqueId;

    public Produto() {
    }

    public Produto(int id, String nome, String descricao, double preco, int quantidadeMinima, Integer estoqueId) {
        setId(id);
        setNome(nome);
        setDescricao(descricao);
        setPreco(preco);
        setQuantidadeMinima(quantidadeMinima);
        setEstoqueId(estoqueId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new InformacaoInvalidaException("o id do produto deve ser maior que zero");
        }

        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new CampoObrigatorioException("o nome do produto é obrigatório");
        }

        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new CampoObrigatorioException("a descrição do produto é obrigatória");
        }

        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco <= 0) {
            throw new InformacaoInvalidaException("o preço do produto deve ser maior que zero");
        }

        this.preco = preco;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(int quantidadeMinima) {
        if (quantidadeMinima < 0) {
            throw new InformacaoInvalidaException("a quantidade mínima não pode ser negativa");
        }

        this.quantidadeMinima = quantidadeMinima;

    }

    public Integer getEstoqueId() {
        return estoqueId;
    }

    public void setEstoqueId(Integer estoqueId) {
        if (estoqueId == null) {
            throw new CampoObrigatorioException("o estoqueId do produto é obrigatório");
        }
        if (estoqueId <= 0) {
            throw new InformacaoInvalidaException("o estoqueId deve ser maior que zero");
        }
        this.estoqueId = estoqueId;

    }
}