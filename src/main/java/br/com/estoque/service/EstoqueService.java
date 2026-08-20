package br.com.estoque.service;

import br.com.estoque.model.Estoque;
import br.com.estoque.model.Produto;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import java.util.List;

@WebService
@SOAPBinding(style = Style.RPC)
public interface EstoqueService {

    @WebMethod
    Produto cadastrarProduto(Produto produto);

    @WebMethod
    Produto buscarProduto(int id);

    @WebMethod
    List<Produto> listarProdutos();

    @WebMethod
    Produto atualizarProduto(Produto produto);

    @WebMethod
    void excluirProduto(int id);

    @WebMethod
    List<Produto> listarProdutosPorEstoque(Integer estoqueId);

    @WebMethod
    Estoque cadastrarEstoque(String nome, String localizacao, int quantidadeAtual);

    @WebMethod
    Estoque consultarEstoque(Integer id);

    @WebMethod
    List<Estoque> listarEstoques();

    @WebMethod
    Estoque atualizarEstoque(Integer id, String nome, String localizacao, int quantidadeAtual);

    @WebMethod
    boolean excluirEstoque(Integer id);
}