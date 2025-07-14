package br.com.gerenciadorhorarios.view;

import br.com.gerenciadorhorarios.models.Usuario;
import br.com.gerenciadorhorarios.controller.BancoDeUsuarios;
import br.com.gerenciadorhorarios.controller.Navegador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class TelaCadastramento extends JFrame {
    JTextField campoUsuario;
    JPasswordField campoSenha;
    JButton botaoEntrar;
    JButton botaoVoltar;
    private ArrayList<Usuario> usuarios = new ArrayList();

    public TelaCadastramento() {
        this.setTitle("Cadastramento de usuário");
        this.setSize(350, 320);
        this.setLocationRelativeTo((Component)null);
        this.setDefaultCloseOperation(3);
        this.setLayout(new BorderLayout());
        JPanel painelGeral = new JPanel(new BorderLayout());
        painelGeral.setBorder(new EmptyBorder(20, 30, 20, 30));
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, 1));
        JLabel labelUsuario = new JLabel("Usuário:");
        this.campoUsuario = new RoundedTextField(15);
        JLabel labelSenha = new JLabel("Senha:");
        this.campoSenha = new RoundedPasswordField(15);
        this.botaoEntrar = new JButton("Cadastrar");
        this.botaoVoltar = new JButton("Voltar");
        labelUsuario.setAlignmentX(0.5F);
        this.campoUsuario.setAlignmentX(0.5F);
        labelSenha.setAlignmentX(0.5F);
        this.campoSenha.setAlignmentX(0.5F);
        this.botaoEntrar.setAlignmentX(0.5F);
        this.botaoVoltar.setAlignmentX(0.5F);
        painel.add(labelUsuario);
        painel.add(this.campoUsuario);
        painel.add(Box.createVerticalStrut(20));
        painel.add(labelSenha);
        painel.add(this.campoSenha);
        painel.add(Box.createVerticalStrut(20));
        painel.add(this.botaoEntrar);
        painel.add(Box.createVerticalStrut(10));
        painel.add(this.botaoVoltar);
        painelGeral.add(painel, "Center");
        this.add(painelGeral, "Center");
        this.botaoEntrar.addActionListener((e) -> this.validarCadastro());
        botaoVoltar.addActionListener(e ->
                Navegador.trocarTela(this, new TelaLogin())
        );
        this.setVisible(true);
    }

    public boolean validarCadastro() {
        String user = this.campoUsuario.getText().trim();
        String senha = new String(this.campoSenha.getPassword());
        if (BancoDeUsuarios.usuarioExiste(user)) {
            JOptionPane.showMessageDialog(this, "Usuário já existe!");
            return false;
        } else {
            Usuario novoUsuario = new Usuario(user, senha);
            BancoDeUsuarios.adicionarUsuario(novoUsuario);
            JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
            new TelaLogin();
            this.dispose();
            return true;
        }
    }


    class RoundedTextField extends JTextField {
        public RoundedTextField(int columns) {
            super(columns);
            this.setOpaque(false);
        }

        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.WHITE);
            g2.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 15, 15);
            g2.setColor(Color.GRAY);
            g2.drawRoundRect(0, 0, this.getWidth() - 1, this.getHeight() - 1, 15, 15);
            super.paintComponent(g2);
            g2.dispose();
        }

        public void setBorder(Border border) {
        }
    }

    class RoundedPasswordField extends JPasswordField {
        public RoundedPasswordField(int columns) {
            super(columns);
            this.setOpaque(false);
        }

        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.WHITE);
            g2.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 15, 15);
            g2.setColor(Color.GRAY);
            g2.drawRoundRect(0, 0, this.getWidth() - 1, this.getHeight() - 1, 15, 15);
            super.paintComponent(g2);
            g2.dispose();
        }

        public void setBorder(Border border) {
        }
    }
}

