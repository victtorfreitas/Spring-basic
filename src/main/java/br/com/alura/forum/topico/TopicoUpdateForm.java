package br.com.alura.forum.topico;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class TopicoUpdateForm {

    @NotNull
    @NotBlank
    private String titulo;

    @NotNull
    @NotBlank
    private String mensagem;

    public Topico update(Topico topico) {
        topico.setTitulo(titulo);
        topico.setMensagem(mensagem);
        return topico;
    }
}
