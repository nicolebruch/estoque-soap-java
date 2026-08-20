package br.com.estoque.service;

import br.com.estoque.controller.EstoqueController;
import br.com.estoque.controller.ProdutoController;
import br.com.estoque.model.Estoque;
import br.com.estoque.model.Produto;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "br.com.estoque.service.EstoqueService")
public class EstoqueServiceImpl implements EstoqueService {

    private final EstoqueController estoqueController;
    private final ProdutoController produtoController;

    public EstoqueServiceImpl() {
        estoqueController = new EstoqueController();
        produtoController = new ProdutoController(estoqueController);
    }

    @Override
    public Produto cadastrarProduto(Produto produto) {
        return produtoController.cadastrar(produto);
    }

    @Override
    public Produto buscarProduto(int id) {
        return produtoController.buscar(id);
    }

    @Override
    public List<Produto> listarProdutos() {
        return produtoController.listar();
    }

    @Override
    public Produto atualizarProduto(Produto produto) {
        return produtoController.atualizar(produto);
    }

    @Override
    public void excluirProduto(int id) {
        produtoController.excluir(id);
    }

    @Override
    public List<Produto> listarProdutosPorEstoque(Integer estoqueId) {
        return produtoController.listarPorEstoque(estoqueId);
    }

    @Override
    public Estoque cadastrarEstoque(String nome, String localizacao, int quantidadeAtual) {
        return estoqueController.cadastrar(nome, localizacao, quantidadeAtual);
    }

    @Override
    public Estoque consultarEstoque(Integer id) {
        return estoqueController.consultar(id);
    }

    @Override
    public List<Estoque> listarEstoques() {
        return estoqueController.listarTodos();
    }

    @Override
    public Estoque atualizarEstoque(Integer id, String nome, String localizacao, int quantidadeAtual) {
        return estoqueController.atualizar(id, nome, localizacao, quantidadeAtual);
    }

    @Override
    public boolean excluirEstoque(Integer id) {
        return estoqueController.excluir(id);
    }
}