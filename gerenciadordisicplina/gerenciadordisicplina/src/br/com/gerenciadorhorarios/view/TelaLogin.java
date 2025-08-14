package br.com.gerenciadorhorarios.view;

import br.com.gerenciadorhorarios.models.GridBagConstraintsBuilding;
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
        this.campoUsuario = new JTextField(15);
        this.campoSenha = new JPasswordField(15);
        this.botaoEntrar = new JButton("Entrar");
        this.botaoCadastrar = new JButton("Cadastramento");
        Insets gbcInsets = new Insets(5, 10,5, 10);
        this.add(new JLabel("Usuário:"),
                new GridBagConstraintsBuilding.Builder().insets(gbcInsets).gridy(0).gridx(0).anchor(13).build());
        this.add(this.campoUsuario,
                new GridBagConstraintsBuilding.Builder().insets(gbcInsets).gridx(1).gridy(0).weightx(1.0).fill(2).anchor(17).build());
        this.add(new JLabel("Senha:"),
                new GridBagConstraintsBuilding.Builder().insets(gbcInsets).gridx(0).gridy(1).anchor(13).build());
        this.add(this.campoSenha,
                new GridBagConstraintsBuilding.Builder().insets(gbcInsets).gridx(1).gridy(1).weightx(1.0).fill(2).anchor(17).build());
        this.add(this.botaoEntrar,
                new GridBagConstraintsBuilding.Builder().insets(gbcInsets).gridx(0).gridy(2).gridwidth(2).build());
        this.add(this.botaoCadastrar,
                new GridBagConstraintsBuilding.Builder().insets(gbcInsets).gridy(3).gridy(3).gridwidth(2).build());
        this.botaoEntrar.addActionListener((e) -> this.tratamentoExcecao());
        botaoCadastrar.addActionListener(e ->
                Navegador.trocarTela(this, new TelaCadastramento())
        );
        this.setVisible(true);
    }

    public void tratamentoExcecao(){
        //verifica se ha excecao propagada por validarLogin
        try{
            validarLogin();
        } catch (NullPointerException e){
            JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos!");
        }
    }

    public void validarLogin() throws NullPointerException {

        /* coleta dados de campoUsario e campoSenha passados pelo usuario
        faz uso do metodo autenticar da class BancodeUsuarios para
        verificar se os dados passados se encontram no banco e
        lanca excepetion se o metodo retornar um valor null*/

        String user = this.campoUsuario.getText();
        String senha = new String(this.campoSenha.getPassword());

        if(BancoDeUsuarios.autenticar(user, senha) == null)
            throw new NullPointerException(); // excecao e propagada para TramentoExcecao
        Navegador.trocarTela(this,
                new TelaPrincipal(BancoDeUsuarios.autenticar(user, senha)));
    }


}

