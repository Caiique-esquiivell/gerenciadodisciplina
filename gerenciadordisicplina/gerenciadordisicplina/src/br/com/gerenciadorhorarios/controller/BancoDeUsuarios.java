package br.com.gerenciadorhorarios.controller;

import br.com.gerenciadorhorarios.models.Usuario;

import java.util.ArrayList;

public class BancoDeUsuarios {
    private static ArrayList<Usuario> usuarios = new ArrayList();

    public static boolean adicionarUsuario(Usuario u) {
        for(Usuario existente : usuarios) {
            if (existente.getUsuario().equals(u.getUsuario())) {
                return false;
            }
        }

        usuarios.add(u);
        return true;
    }

    public static boolean usuarioExiste(String nome) {
        for(Usuario u : usuarios) {
            if (u.getUsuario().equals(nome)) {
                return true;
            }
        }

        return false;
    }

    public static Usuario autenticar(String nome, String senha) {
        for(Usuario u : usuarios) {
            if (u.getUsuario().equals(nome) && senha.equals(u.getSenha())) {
                return u;
            }
        }

        return null;
    }
}

