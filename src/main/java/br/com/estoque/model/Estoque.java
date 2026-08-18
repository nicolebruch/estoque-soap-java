package br.com.estoque.model;

import br.com.estoque.exception.CampoObrigatorioException;
import br.com.estoque.exception.InformacaoInvalidaException;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Estoque {

    private Integer id;
    private String nome;
    private String localizacao;
    private int quantidadeAtual;
    private ArrayList<Produto> produtos = new ArrayList<>();

    public Estoque() {
        // construtor vazio para o JAXB conseguir montar o objeto ao ler XML
    }

    public Estoque(Integer id, String nome, String localizacao, int quantidadeAtual)
            throws CampoObrigatorioException, InformacaoInvalidaException {
        setId(id);
        setNome(nome);
        setLocalizacao(localizacao);
        setQuantidadeAtual(quantidadeAtual);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) throws CampoObrigatorioException, InformacaoInvalidaException {
        if (id == null) throw new CampoObrigatorioException("O Campo 'id' é obrigatório."); /*Precisa ser implementado*/
        if (id <= 0) throw new InformacaoInvalidaException("O 'id' deve ser um número positivo.");
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws CampoObrigatorioException, InformacaoInvalidaException {
        if (nome == null || nome.trim().isEmpty())
            throw new CampoObrigatorioException("O campo 'nome' é obrigatório."); /*Precisa ser implementado*/
        String nomeLimpo = nome.trim();
        if (nomeLimpo.length() < 2 || nomeLimpo.length() > 100)
            throw  new InformacaoInvalidaException("O nome do produto deve ter de 2 e 100 caracteres.");
        this.nome = nomeLimpo;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) throws CampoObrigatorioException {
        if (localizacao == null || localizacao.trim().isEmpty())
            throw new CampoObrigatorioException("O campo 'localização' é obrigatório."); /*Precisa ser implementado*/
        this.localizacao = localizacao.trim();
    }

    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }

    public void setQuantidadeAtual(int quantidadeAtual) throws  InformacaoInvalidaException {
        if (quantidadeAtual < 0)
            throw  new InformacaoInvalidaException("A 'quantidade Atual' não pode ser negativa.");
        this.quantidadeAtual = quantidadeAtual;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) throws InformacaoInvalidaException {
        if (produtos == null) throw  new InformacaoInvalidaException("A lista de produtos não pode ser nula.");
        if (quantidadeAtual > 0 && produtos.size() > quantidadeAtual)
            throw new InformacaoInvalidaException("A quantidade de produtos excede a 'quantidade Atual' do estoque.");
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Estoque{id=" + id + ", Nome='" + nome + ", Localização='" + localizacao + "', Quantidade atual=" + quantidadeAtual + ", Quantidade de produtos=" + produtos.size() + "}";
    }
}