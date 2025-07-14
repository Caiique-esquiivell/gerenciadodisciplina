package br.com.gerenciadorhorarios.controller;

import br.com.gerenciadorhorarios.models.Disciplina;
import br.com.gerenciadorhorarios.models.Horario;

import java.util.HashMap;
import java.util.Map;

public class GradeHoraria {
    private Map<Disciplina, Horario> grade = new HashMap();

    public boolean adicionar(Disciplina d, Horario h) {
        if (possuiSobreposicao(h)) {
            return false;
        }
        grade.put(d, h);
        return true;
    }

    public boolean removerPorCodigo(String codigo) {
        Disciplina disciplinaParaRemover = null;

        for(Disciplina d : this.grade.keySet()) {
            if (d.getCodigo().equals(codigo)) {
                disciplinaParaRemover = d;
                break;
            }
        }

        if (disciplinaParaRemover != null) {
            this.grade.remove(disciplinaParaRemover);
            return true;
        } else {
            return false;
        }


    }

    public boolean possuiSobreposicao(Horario novoHorario) {
        for (Horario h : grade.values()) {
            if (h.getDiaSemana().equals(novoHorario.getDiaSemana())) {
                int inicioExistente = h.getHoraInicio();
                int fimExistente = h.getHoraFim();

                int novoInicio = novoHorario.getHoraInicio();
                int novoFim = novoHorario.getHoraFim();

                if (novoInicio < fimExistente && novoFim > inicioExistente) {
                    return true; // Conflito encontrado
                }
            }
        }
        return false;
    }


    public Map<Disciplina, Horario> getGrade() {
        return this.grade;
    }



}

