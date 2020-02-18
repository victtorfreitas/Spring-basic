package br.com.alura.forum.topico;

import br.com.alura.forum.curso.Curso;
import br.com.alura.forum.resposta.Resposta;
import br.com.alura.forum.usuario.Usuario;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private TopicoStatus status;

    @ManyToOne
    private Usuario autor;

    @ManyToOne
    private Curso curso;

    @OneToMany(mappedBy = "topico")
    private List<Resposta> respostas;

    public Topico() {
        this.dataCriacao = LocalDateTime.now();
        this.status = TopicoStatus.NAO_RESPONDIDO;
        this.respostas = new ArrayList<>();
    }

    public Topico(String titulo, String mensagem, Curso curso) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.curso = curso;
        this.dataCriacao = LocalDateTime.now();
        this.status = TopicoStatus.NAO_RESPONDIDO;
        this.respostas = new ArrayList<>();
    }
}
