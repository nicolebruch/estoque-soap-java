package br.com.estoque.exception;

public class CampoObrigatorioException extends RuntimeException {

    public CampoObrigatorioException(String mensagem) {
        super(mensagem);
    }
}