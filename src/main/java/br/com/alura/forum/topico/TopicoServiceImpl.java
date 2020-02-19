package br.com.alura.forum.topico;

import br.com.alura.forum.config.erros.NotFoundRegistroException;
import br.com.alura.forum.curso.Curso;
import br.com.alura.forum.curso.CursoService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

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

    @Override
    public DetalharTopicoDTO detalhar(Long id) {
        Topico topico = topicoRepository.findById(id).orElseThrow(getNotFoundRegistroExceptionSupplier());
        return new DetalharTopicoDTO(topico);
    }

    @NotNull
    private Supplier<NotFoundRegistroException> getNotFoundRegistroExceptionSupplier() {
        return () -> new NotFoundRegistroException("Topico não encontrado!");
    }

    private Topico findById(Long id) {
        return topicoRepository.getOne(id);
    }
}
