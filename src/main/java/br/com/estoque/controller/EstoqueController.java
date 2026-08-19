package br.com.estoque.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.estoque.exception.InformacaoInvalidaException;
import br.com.estoque.exception.CampoObrigatorioException;
import br.com.estoque.model.Estoque;
import br.com.estoque.model.Produto;

public class EstoqueController {

    private final Map<Integer, Estoque> estoques = new HashMap<>();
    private int proximoId = 1;
    private final ProdutoController produtoController;

    public EstoqueController(ProdutoController produtoController){
        this.produtoController = produtoController;
    }

    public Estoque cadastrar(String nome, String localizacao, int quantidadeAtual) throws CampoObrigatorioException, InformacaoInvalidaException{
        Estoque estoque = new Estoque(proximoId, nome, localizacao, quantidadeAtual);
        estoques.put(estoque.getId(), estoque);
        proximoId++;
        return estoque;
    }

    private void sincronizarProdutos(Estoque estoque){
        List<Produto> produtosDoEstoque = produtoController.listarPorEstoque/*necessita implementação*/(estoque.getId());
        try {
            estoque.setProdutos(new ArrayList<>(produtosDoEstoque));
        } catch (InformacaoInvalidaException e) {
            System.err.println("Aviso: " + e.getMessage());
        }
    }

    public Estoque consultar(Integer id) throws InformacaoInvalidaException {
        Estoque estoque = estoques.get(id);
        if (estoque == null) throw new InformacaoInvalidaException("Estoque com o id " + id + " não encontrado.");
        sincronizarProdutos(estoque);
        return estoque;
    }

    public List<Estoque> listarTodos() {
        List<Estoque> lista = new ArrayList<>(estoques.values());
        for (Estoque e : lista) sincronizarProdutos(e);
        return lista;
    }

    public Estoque atualizar(Integer id, String nome, String localizacao, int quantidadeAtual) throws CampoObrigatorioException, InformacaoInvalidaException{
        Estoque estoque = consultar(id);
        estoque.setNome(nome);
        estoque.setLocalizacao(localizacao);
        estoque.setQuantidadeAtual(quantidadeAtual);
        return estoque;
    }

    public boolean excluir (Integer id) throws InformacaoInvalidaException{
        consultar(id);
        estoques.remove(id);
        return true;
    }
}