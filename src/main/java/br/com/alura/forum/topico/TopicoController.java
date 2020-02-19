package br.com.alura.forum.topico;

import br.com.alura.forum.config.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = TopicoController.TOPICO_PATH)
public class TopicoController {
    public static final String TOPICO_PATH = "/topicos";
    TopicoService topicoService;

    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @GetMapping
    public List<TopicoDTO> lista() {
        return topicoService.listar();
    }

    @GetMapping(params = "filtrar")
    public List<TopicoDTO> filtro(String nomeCurso) {
        return topicoService.findByCursoNome(nomeCurso);
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid TopicoForm topicoForm,
                                       UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = topicoService.salvar(topicoForm);
        return Response.created(uriComponentsBuilder, new TopicoDTO(topico), TOPICO_PATH);
    }

    @GetMapping("/{id}")
    public DetalharTopicoDTO detalhar(@PathVariable Long id) {
        DetalharTopicoDTO detalhar = topicoService.detalhar(id);
        return detalhar;
    }
}
