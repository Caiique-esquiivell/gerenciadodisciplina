package br.com.gerenciadorhorarios.view;

import br.com.gerenciadorhorarios.models.*;
import br.com.gerenciadorhorarios.controller.Navegador;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.Map;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;

public class TelaPrincipal extends JFrame {
    private Usuario usuario;

    public TelaPrincipal(Usuario usuario) {
        this.usuario = usuario;
        this.setTitle("Gerenciador de Disciplinas");
        this.setSize(400, 300);
        this.setLocationRelativeTo((Component)null);
        this.setDefaultCloseOperation(3);
        this.setLayout(new BorderLayout());
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new BoxLayout(painelBotoes, 1));
        JButton btnAdicionar = new JButton("Adicionar Disciplina");
        JButton btnRemover = new JButton("Remover Disciplina");
        JButton btnVisualizar = new JButton("Visualizar Grade");
        JButton botaoVoltar = new JButton("Voltar");
        btnAdicionar.setAlignmentX(0.5F);
        btnRemover.setAlignmentX(0.5F);
        btnVisualizar.setAlignmentX(0.5F);
        botaoVoltar.setAlignmentX(0.5F);
        btnAdicionar.addActionListener((e) -> this.adicionarDisciplina());
        btnRemover.addActionListener((e) -> this.removerDisciplina());
        btnVisualizar.addActionListener((e) -> this.visualizarGrade());
        botaoVoltar.addActionListener(e ->
                Navegador.trocarTela(this, new TelaLogin())
        );
        painelBotoes.add(Box.createVerticalStrut(20));
        painelBotoes.add(btnAdicionar);
        painelBotoes.add(Box.createVerticalStrut(25));
        painelBotoes.add(btnRemover);
        painelBotoes.add(Box.createVerticalStrut(25));
        painelBotoes.add(btnVisualizar);
        painelBotoes.add(Box.createVerticalStrut(20));
        painelBotoes.add(Box.createVerticalStrut(25));
        painelBotoes.add(botaoVoltar);
        this.add(painelBotoes, "Center");
        this.setVisible(true);
    }

    private void adicionarDisciplina() {

        String nome = JOptionPane.showInputDialog("Nome da disciplina:");
        String codigo = JOptionPane.showInputDialog("Código:");
        String professor = JOptionPane.showInputDialog("Professor:");

        JComboBox<DiaDaSemana> comboDia = new JComboBox<>(DiaDaSemana.values());
        JOptionPane.showMessageDialog(this, comboDia, "Selecione o dia da semana", JOptionPane.QUESTION_MESSAGE);
        DiaDaSemana dia = (DiaDaSemana) comboDia.getSelectedItem();

        String[] horarios = new String[16];

        JComboBox<HorarioEnum> comboInicio;
        comboInicio = new JComboBox<>(HorarioEnum.values());
        JOptionPane.showMessageDialog(this, comboInicio, "Selecione a hora de início", JOptionPane.QUESTION_MESSAGE);
        HorarioEnum inicio = (HorarioEnum) comboInicio.getSelectedItem();

        JComboBox<HorarioEnum> comboFim = new JComboBox<>(HorarioEnum.values());
        JOptionPane.showMessageDialog(this, comboFim, "Selecione a hora de fim", JOptionPane.QUESTION_MESSAGE);
        HorarioEnum fim = (HorarioEnum) comboFim.getSelectedItem();

        if (inicio.ordinal() >= fim.ordinal()) {
            JOptionPane.showMessageDialog(this, "Horário de início deve ser antes do horário final!");
            return;
        }

        String sala = JOptionPane.showInputDialog("Sala:");

        Disciplina d = new Disciplina(nome, codigo, professor);
        Horario h = new Horario(dia,inicio,fim, sala);


        boolean sucesso = this.usuario.adicionarDisciplina(d, h);
        ;

        if (!sucesso) {
            JOptionPane.showMessageDialog(this, "Horário conflita com outra disciplina cadastrada!");
            return;
        }

    }

    private void removerDisciplina() {
        String codigo = JOptionPane.showInputDialog("Digite o código da disciplina a remover:");
        boolean removido = this.usuario.removerDisciplina(codigo);
        if (removido) {
            JOptionPane.showMessageDialog(this, "Disciplina removida.");
        } else {
            JOptionPane.showMessageDialog(this, "Disciplina não encontrada.");
        }

    }

    private void visualizarGrade() {
        Map<Disciplina, Horario> gradeMap = this.usuario.getGrade().getGrade();
        if (gradeMap.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhuma disciplina cadastrada na grade.");
        } else {
            StringBuilder sb = new StringBuilder("------ GRADE DE HORÁRIOS ------\n\n");

            for(Map.Entry<Disciplina, Horario> entry : gradeMap.entrySet()) {
                Disciplina d = (Disciplina) entry.getKey();
                Horario h = (Horario)entry.getValue();
                sb.append("Código: ").append(d.getCodigo()).append("\n").append("Nome: ").append(d.getNome()).append("\n").append("Professor: ").append(d.getProfessor()).append("\n").append("Horário: ").append(h.getFormatDiaSemana()).append(" | ").append(h.getFormatHoraInicio()).append(" - ").append(h.getFormatHoraFim()).append("\n").append("Sala: ").append(h.getSala()).append("\n").append("------------------------------\n");
            }

            JOptionPane.showMessageDialog(this, sb.toString(), "Grade Horária", 1);
        }
    }
}

