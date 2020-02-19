package br.com.alura.forum.config;

import br.com.alura.forum.config.erros.ErroDeFormularioDTO;
import br.com.alura.forum.config.erros.NotFoundRegistroException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErroValidationHandler extends ResponseEntityExceptionHandler {
    private final MessageSource messageSource;

    public ErroValidationHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Erro> erros = exception.getBindingResult()
                .getFieldErrors().stream()
                .map(er -> new Erro(messageSource.getMessage(er, LocaleContextHolder.getLocale()), er.getField())).collect(Collectors.toList());
        return handleExceptionInternal(exception, erros, new HttpHeaders(), status, request);
    }


    @ExceptionHandler(NotFoundRegistroException.class)
    public ResponseEntity<?> NotFoundRegistroException(NotFoundRegistroException exception, WebRequest request) {
        String mensagemDev = ExceptionUtils.getRootCauseMessage(exception);
        List<Erro> erros = Collections.singletonList(new Erro(mensagemDev, exception.getMessage()));
        return handleExceptionInternal(exception, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    public static class Erro {
        public String mensagemDesenvolvedor;
        public String mensagemUsuario;

        public Erro(String mensagemDesenvolvedor, String mensagemUsuario) {
            this.mensagemDesenvolvedor = mensagemDesenvolvedor;
            this.mensagemUsuario = mensagemUsuario;
        }
    }

}

