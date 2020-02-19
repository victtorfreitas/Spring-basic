package br.com.alura.forum.topico;

import br.com.alura.forum.resposta.RespostaDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class DetalharTopicoDTO {
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String nomeAutor;
    private TopicoStatus status;
    private List<RespostaDTO> respostas;


    public DetalharTopicoDTO(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        this.nomeAutor = topico.getAutor().getNome();
        this.status = topico.getStatus();
        this.respostas = topico.getRespostas().stream().map(RespostaDTO::new).collect(Collectors.toList());
    }
}
