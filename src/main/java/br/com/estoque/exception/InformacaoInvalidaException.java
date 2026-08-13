package br.com.estoque.exception;

import javax.xml.ws.WebFault;

@WebFault(name = "InformacaoInvalidaFault")
public class InformacaoInvalidaException extends RuntimeException {

    public  InformacaoInvalidaException(String message) {
        super(message);
    }
}