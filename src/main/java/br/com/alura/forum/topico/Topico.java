package br.com.alura.forum.topico;

import br.com.alura.forum.curso.Curso;
import br.com.alura.forum.resposta.Resposta;
import br.com.alura.forum.usuario.Usuario;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Topico {

    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private TopicoStatus status;
    private Usuario autor;
    private Curso curso;
    private List<Resposta> respostas;

    public Topico() {
        this.status = TopicoStatus.NAO_RESPONDIDO;
        this.respostas = new ArrayList<>();
    }
    public Topico(String titulo, String mensagem, Curso curso) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.curso = curso;
    }
}
