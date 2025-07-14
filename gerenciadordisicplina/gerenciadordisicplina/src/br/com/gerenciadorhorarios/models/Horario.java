package br.com.gerenciadorhorarios.models;

public class Horario {
    private DiaDaSemana diaSemana;
    private HorarioEnum horaInicio;
    private HorarioEnum horaFim;
    private String sala;

    public Horario(DiaDaSemana diaSemana, HorarioEnum horaInicio, HorarioEnum horaFim, String sala) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.sala = sala;
    }

    public DiaDaSemana getDiaSemana() {return this.diaSemana;
    }

    public String getFormatDiaSemana() {return this.diaSemana.toString();
    }

    public int getHoraFim() {
        return this.horaFim.getHora();
    }

    public String getFormatHoraFim() {
        return this.horaFim.toString();
    }

    public String getSala() {
        return this.sala;
    }

    public int getHoraInicio() {
        return this.horaInicio.getHora();
    }
    public String getFormatHoraInicio() {
        return this.horaInicio.toString();
    }
}

