package com.java;

public class UsuarioValidacao {

    public boolean valida(Usuario usuario) {
	if (!this.validaLogin(usuario.getLogin())) {
	    return false;
	}

	if (!this.validaSenha(usuario.getSenha())) {
	    return false;
	}
	return true;
    }

    private boolean validaLogin(String login) {

	if (login == null || login.length() == 0) {
	    System.out.println("Login nao pode ser vazio!");
	    return false;
	}
	
	if (login.length() < 6) {
	    System.out.println("Login deve conter ao mesmo 6 caracteres!");
	    return false;
	}

	if (login.length() > 20) {
	    System.out.println("Login deve conter no maximo 20 caracteres!");
	    return false;
	}

	return true;
    }

    private boolean validaSenha(String senha) {
	
	if (senha == null || senha.length() == 0) {
	    System.out.println("Senha nao pode ser vazio!");
	    return false;
	}
	
	if (!senha.matches("[0-9a-z]{40}")) {
	    System.out.println("Senha invalida!");
	    return false;
	}

	return true;
    }
}
