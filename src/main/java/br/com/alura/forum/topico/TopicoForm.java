package br.com.alura.forum.topico;

import br.com.alura.forum.curso.Curso;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class TopicoForm {

    @NotNull @NotBlank
    private String titulo;

    @NotNull @NotBlank
    private String mensagem;

    @NotNull @NotBlank
    private String nomeCurso;

    public Topico converteToEntityWithCurso(Curso curso) {
        return new Topico(titulo, mensagem, curso);
    }
}
