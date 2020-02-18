package br.com.alura.forum.config;

import br.com.alura.forum.config.erros.ErroDeFormularioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroValidationHandler {
    private final MessageSource messageSource;

    public ErroValidationHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroDeFormularioDTO> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ErroDeFormularioDTO> erros = new ArrayList<>();
        exception.getBindingResult()
                .getFieldErrors().stream()
                .forEach(er ->
                        erros.add(
                                new ErroDeFormularioDTO(er.getField(),
                                        messageSource.getMessage(er, LocaleContextHolder.getLocale())
                                ))

                )
        ;
        return erros;
    }
}

