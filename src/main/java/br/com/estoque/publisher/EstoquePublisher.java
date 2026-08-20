package br.com.estoque.publisher;

import br.com.estoque.service.EstoqueServiceImpl;

import javax.xml.ws.Endpoint;

public class EstoquePublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:9876/estoque", new EstoqueServiceImpl());
        System.out.println("web service publicado:");
        System.out.println("http://127.0.0.1:9876/estoque?wsdl");
    }
}