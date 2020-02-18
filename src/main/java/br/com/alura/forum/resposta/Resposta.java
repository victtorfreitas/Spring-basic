package br.com.alura.forum.resposta;

import br.com.alura.forum.topico.Topico;
import br.com.alura.forum.usuario.Usuario;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;

    @ManyToOne
    private Topico topico;
    private LocalDateTime dataCriacao;

    @ManyToOne
    private Usuario autor;
    private Boolean solucao;

    public Resposta() {
        this.dataCriacao = LocalDateTime.now();
        this.solucao = false;
    }
}
