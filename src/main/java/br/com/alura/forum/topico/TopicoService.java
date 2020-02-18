package br.com.alura.forum.topico;

import java.util.List;

public interface TopicoService {
    List<TopicoDTO> listar();

    List<TopicoDTO> findByCursoNome(String nomeCurso);

    Topico salvar(TopicoForm topicoForm);
}
