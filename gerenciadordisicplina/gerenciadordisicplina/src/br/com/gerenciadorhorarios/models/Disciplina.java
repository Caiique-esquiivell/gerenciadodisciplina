package br.com.gerenciadorhorarios.models;

import java.util.Objects;

public class Disciplina {
    private String nome;
    private String codigo;
    private String professor;

    public Disciplina(String nome, String codigo, String professor) {
        this.nome = nome;
        this.codigo = codigo;
        this.professor = professor;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getProfessor() {
        return this.professor;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Disciplina)) {
            return false;
        } else {
            Disciplina d = (Disciplina)o;
            return Objects.equals(this.codigo, d.codigo);
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.codigo});
    }
}

