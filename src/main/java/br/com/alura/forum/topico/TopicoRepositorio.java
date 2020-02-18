package br.com.alura.forum.topico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepositorio extends JpaRepository<Topico, Long> {

    List<Topico> findByCursoNome(String nomeCurso);
}
