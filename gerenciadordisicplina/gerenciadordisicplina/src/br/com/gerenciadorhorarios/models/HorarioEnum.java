package br.com.gerenciadorhorarios.models;

public enum HorarioEnum {
    H07(7), H08(8), H09(9), H10(10), H11(11), H12(12),
    H13(13), H14(14), H15(15), H16(16), H17(17), H18(18),
    H19(19), H20(20), H21(21), H22(22);

    private final int hora;

    HorarioEnum(int hora) {
        this.hora = hora;
    }

    public int getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return String.format("%02d:00", hora);
    }
}

