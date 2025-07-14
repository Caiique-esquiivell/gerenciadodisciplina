package br.com.gerenciadorhorarios.models;

import br.com.gerenciadorhorarios.controller.GradeHoraria;

public class Usuario {
    private String nome;
    private String senha;
    private GradeHoraria grade;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.grade = new GradeHoraria();
    }

    public String getUsuario() {
        return this.nome;
    }

    public String getSenha() {
        return this.senha;
    }

    public boolean adicionarDisciplina(Disciplina d, Horario h) {
        return this.grade.adicionar(d, h);
    }

    public boolean removerDisciplina(String codigo) {
        return this.grade.removerPorCodigo(codigo);
    }

    public GradeHoraria getGrade() {
        return this.grade;
    }
}

