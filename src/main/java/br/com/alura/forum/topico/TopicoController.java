package br.com.alura.forum.topico;

import br.com.alura.forum.curso.Curso;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicoController {

    @RequestMapping("/topicos")
    public List<TopicoDTO> lista() {
        Topico topico = new Topico("Dúvida", "Duvida com Spring",
                new Curso("Spring", "Programação"));
        return TopicoDTO.convertToList(Arrays.asList(topico, topico, topico));
    }
}
