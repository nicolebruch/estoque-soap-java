package br.com.estoque.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.estoque.exception.InformacaoInvalidaException;
import br.com.estoque.model.Estoque;
import br.com.estoque.model.Produto;

public class ProdutoController {

    private final EstoqueController estoqueController;

    public ProdutoController(EstoqueController estoqueController) {
        this.estoqueController = estoqueController;
    }

    public Produto cadastrar(Produto produto) throws InformacaoInvalidaException {
        if (produto == null) {
            throw new IllegalArgumentException("o produto não pode ser nulo");
        }
        if (buscar(produto.getId()) != null) {
            throw new IllegalArgumentException("já existe um produto com esse id");
        }

        Estoque estoque = estoqueController.consultar(produto.getEstoqueId());
        estoque.getProdutos().add(produto);
        return produto;
    }

    public Produto buscar(int id) {
        for (Estoque estoque : estoqueController.listarTodos()) {
            for (Produto produto : estoque.getProdutos()) {
                if (produto.getId() == id) {
                    return produto;
                }
            }
        }
        return null;
    }

    public List<Produto> listar() {
        List<Produto> todos = new ArrayList<>();
        for (Estoque estoque : estoqueController.listarTodos()) {
            todos.addAll(estoque.getProdutos());
        }
        return todos;
    }

    public Produto atualizar(Produto produtoAtualizado) {
        if (produtoAtualizado == null) {
            throw new IllegalArgumentException("o produto não pode ser nulo");
        }
        for (Estoque estoque : estoqueController.listarTodos()) {
            List<Produto> lista = estoque.getProdutos();
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getId() == produtoAtualizado.getId()) {
                    lista.set(i, produtoAtualizado);
                    return produtoAtualizado;
                }
            }
        }
        throw new IllegalArgumentException("produto não encontrado");
    }

    public void excluir(int id) {
        for (Estoque estoque : estoqueController.listarTodos()) {
            List<Produto> lista = estoque.getProdutos();
            for (Produto produto : lista) {
                if (produto.getId() == id) {
                    lista.remove(produto);
                    return;
                }
            }
        }
        throw new IllegalArgumentException("produto não encontrado");
    }

    public List<Produto> listarPorEstoque(Integer estoqueId) throws InformacaoInvalidaException {
        Estoque estoque = estoqueController.consultar(estoqueId);
        return estoque.getProdutos();
    }
}