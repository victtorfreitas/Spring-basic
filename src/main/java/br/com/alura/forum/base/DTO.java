package br.com.alura.forum.base;

import lombok.Data;

@Data
public class DTO {
    private Long id;

    public DTO(Long id) {
        this.id = id;
    }
}
