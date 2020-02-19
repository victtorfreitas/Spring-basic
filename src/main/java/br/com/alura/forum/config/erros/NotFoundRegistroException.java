package br.com.alura.forum.config.erros;

import java.util.function.Supplier;

public class NotFoundRegistroException extends RuntimeException {

    public NotFoundRegistroException(String mensagem){
        super(mensagem);
    }
}
