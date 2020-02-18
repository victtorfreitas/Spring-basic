package br.com.alura.forum.config;

import br.com.alura.forum.base.DTO;
import br.com.alura.forum.topico.TopicoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class Response {


    public static ResponseEntity<?> created(UriComponentsBuilder uriComponentsBuilder, DTO body, String path) {
        URI uri = uriComponentsBuilder.path(path + "/{id}").buildAndExpand(body.getId()).toUri();
        return ResponseEntity.created(uri).body(body);
    }
}
