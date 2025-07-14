package br.com.gerenciadorhorarios.models;

public enum DiaDaSemana {
    SEGUNDA_FEIRA,
    TERCA_FEIRA,
    QUARTA_FEIRA,
    QUINTA_FEIRA,
    SEXTA_FEIRA;

    @Override
    public String toString() {
        return name().replace("_", "-feira").substring(0, 1) + name().toLowerCase().substring(1).replace("_", " ");
    }
}



