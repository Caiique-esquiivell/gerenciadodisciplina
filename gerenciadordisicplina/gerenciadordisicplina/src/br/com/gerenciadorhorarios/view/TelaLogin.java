package br.com.gerenciadorhorarios.view;

import br.com.gerenciadorhorarios.models.Usuario;
import br.com.gerenciadorhorarios.controller.BancoDeUsuarios;
import br.com.gerenciadorhorarios.controller.Navegador;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaLogin extends JFrame {
    private JTextField campoUsuario;
    private JPasswordField campoSenha;
    private JButton botaoEntrar;
    private JButton botaoCadastrar;

    public TelaLogin() {
        this.setTitle("Login do Sistema");
        this.setSize(350, 200);
        this.setLocationRelativeTo((Component)null);
        this.setDefaultCloseOperation(3);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        this.campoUsuario = new JTextField(15);
        this.campoSenha = new JPasswordField(15);
        this.botaoEntrar = new JButton("Entrar");
        this.botaoCadastrar = new JButton("Cadastramento");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = 22;
        this.add(new JLabel("Usuário:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = 21;
        this.add(this.campoUsuario, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = 22;
        this.add(new JLabel("Senha:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = 21;
        this.add(this.campoSenha, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = 10;
        this.add(this.botaoEntrar, gbc);
        gbc.gridy = 3;
        this.add(this.botaoCadastrar, gbc);
        this.botaoEntrar.addActionListener((e) -> this.validarLogin());
        botaoCadastrar.addActionListener(e ->
                Navegador.trocarTela(this, new TelaCadastramento())
        );
        this.setVisible(true);
    }

    public void validarLogin() {
        String user = this.campoUsuario.getText();
        String senha = new String(this.campoSenha.getPassword());
        Usuario autenticado = BancoDeUsuarios.autenticar(user, senha);
        if (autenticado != null) {
            Navegador.trocarTela(this, new TelaPrincipal(autenticado));
        }
        else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos!");
        }

    }

}

