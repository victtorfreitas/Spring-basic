package br.com.alura.forum.topico;

import br.com.alura.forum.config.erros.NotFoundRegistroException;

import java.util.List;

public interface TopicoService {
    List<TopicoDTO> listar();

    List<TopicoDTO> findByCursoNome(String nomeCurso);

    Topico salvar(TopicoForm topicoForm);

    DetalharTopicoDTO detalhar(Long id);
}
