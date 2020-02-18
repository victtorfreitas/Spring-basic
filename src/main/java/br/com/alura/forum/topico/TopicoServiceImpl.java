package br.com.alura.forum.topico;

import br.com.alura.forum.curso.Curso;
import br.com.alura.forum.curso.CursoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoServiceImpl implements TopicoService {

    private TopicoRepositorio topicoRepository;
    private CursoService cursoService;

    public TopicoServiceImpl(TopicoRepositorio topicoRepository, CursoService cursoService) {
        this.topicoRepository = topicoRepository;
        this.cursoService = cursoService;
    }

    @Override
    public List<TopicoDTO> listar() {
        return TopicoDTO.convertToList(topicoRepository.findAll());
    }

    @Override
    public List<TopicoDTO> findByCursoNome(String nomeCurso) {
        return TopicoDTO.convertToList(topicoRepository.findByCursoNome(nomeCurso));
    }

    @Override
    public Topico salvar(TopicoForm topicoForm) {
        Curso curso = this.cursoService.findByNome(topicoForm.getNomeCurso());
        return topicoRepository.save(topicoForm.converteToEntityWithCurso(curso));
    }
}
