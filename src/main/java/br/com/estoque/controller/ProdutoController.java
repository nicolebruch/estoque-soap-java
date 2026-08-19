package br.com.estoque.controller;

import br.com.estoque.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoController {

    private final List<Produto> produtos;

    public ProdutoController() {
        produtos = new ArrayList<>();
    }

    public Produto cadastrar(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("o produto não pode ser nulo");
        }

        if (buscar(produto.getId()) != null) {
            throw new IllegalArgumentException("já existe um produto com esse id");
        }

        produtos.add(produto);

        return produto;
    }

    public Produto buscar(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }

        return null;
    }

    public List<Produto> listar() {
        return new ArrayList<>(produtos);
    }

    public Produto atualizar(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("o produto não pode ser nulo");
        }

        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == produto.getId()) {
                produtos.set(i, produto);
                return produto;
            }
        }

        throw new IllegalArgumentException("produto não encontrado");
    }

    public void excluir(int id) {
        Produto produto = buscar(id);

        if (produto == null) {
            throw new IllegalArgumentException("produto não encontrado");
        }

        produtos.remove(produto);

    }

    public List<Produto> listarPorEstoque(Integer estoqueId) {
        List<Produto> resultado = new ArrayList<>();
        for (Produto produto : produtos.values()) {
            if (produto.getEstoqueId() != null && produto.getEstoqueId().equals(estoqueId)) {
                resultado.add(produto);
            }
        }
        return resultado;
    }
}