package br.com.estoque.client;

import br.com.estoque.model.Estoque;
import br.com.estoque.model.Produto;
import br.com.estoque.service.EstoqueService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class EstoqueClient {

    public static void main(String[] args) throws Exception {

        URL url = new URL("http://127.0.0.1:9876/estoque?wsdl");

        QName qname = new QName("http://service.estoque.com.br/", "EstoqueServiceImplService");

        Service ws = Service.create(url, qname);

        EstoqueService service = ws.getPort(EstoqueService.class);

        System.out.println("=== TESTE DE ESTOQUE ===");

        Estoque estoque = service.cadastrarEstoque("Estoque Principal", "Blumenau", 0);

        System.out.println("Estoque cadastrado:");
        System.out.println("ID: " + estoque.getId());
        System.out.println("Nome: " + estoque.getNome());
        System.out.println("Localizacao: " + estoque.getLocalizacao());

        System.out.println();

        System.out.println("=== TESTE DE PRODUTO ===");

        Produto produto = new Produto();

        produto.setId(1);
        produto.setNome("Shampoo");
        produto.setDescricao("Shampoo profissional");
        produto.setPreco(50.0);
        produto.setQuantidadeMinima(10);
        produto.setEstoqueId(estoque.getId());

        Produto produtoCadastrado = service.cadastrarProduto(produto);

        System.out.println("Produto cadastrado:");
        System.out.println("ID: " + produtoCadastrado.getId());
        System.out.println("Nome: " + produtoCadastrado.getNome());

        System.out.println();

        System.out.println("=== PRODUTOS DO ESTOQUE ===");

        Produto[] produtos = service.listarProdutosPorEstoque(estoque.getId());

        for (Produto p : produtos) {
            System.out.println("ID: " + p.getId() + " | Nome: " + p.getNome() + " | Preco: " + p.getPreco());
        }
    }
}