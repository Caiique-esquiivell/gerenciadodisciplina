package br.com.gerenciadorhorarios.controller;

import javax.swing.*;

public class Navegador {
    public static void trocarTela(JFrame atual, JFrame nova) {
        atual.dispose();
        nova.setVisible(true);
    }
}
