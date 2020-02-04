package br.com.alura.forum.curso;

import lombok.Data;

@Data
public class Curso {
    private Long id;
    private String nome;
    private String programacao;
    private String categoria;

    public Curso(String nome, String programacao) {
        this.nome = nome;
        this.programacao = programacao;
    }
}
