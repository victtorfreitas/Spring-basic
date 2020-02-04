package br.com.alura.forum.resposta;

import br.com.alura.forum.topico.Topico;
import br.com.alura.forum.usuario.Usuario;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Resposta {

    private Long id;
    private String mensagem;
    private Topico topico;
    private LocalDateTime dataCriacao;
    private Usuario autor;
    private Boolean solucao;

    public Resposta() {
        this.dataCriacao = LocalDateTime.now();
        this.solucao = false;
    }
}
