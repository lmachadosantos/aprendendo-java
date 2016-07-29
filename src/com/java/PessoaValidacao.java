package com.java;

public class PessoaValidacao {
    public boolean valida(Pessoa pessoa) {
	if (!this.validaNome(pessoa.getNome())) {
	    return false;
	}

	if (!this.validaUsuario(pessoa.getUsuario())) {
	    return false;
	}

	if (!this.validaEmail(pessoa.getEmail())) {
	    return false;
	}

	return true;
    }

    private boolean validaNome(String nome) {

	if (nome == null || nome.length() == 0) {
	    System.out.println("Nome nao pode ser vazio!");
	    return false;
	}

	if (nome.length() < 6) {
	    System.out.println("Nome deve conter ao mesmo 6 caracteres!");
	    return false;
	}

	if (nome.length() > 120) {
	    System.out.println("Nome deve conter no maximo 120 caracteres!");
	    return false;
	}

	return true;
    }

    private boolean validaUsuario(Usuario usuario) {

	if (usuario.getId() <= 0) {
	    System.out.println("Usuario invalido!");
	    return false;
	}

	return true;
    }

    private boolean validaEmail(String email) {

	if (email == null || email.length() == 0) {
	    System.out.println("E-mail nao pode ser vazio!");
	    return false;
	}

	if (!email
		.matches("[a-zA-Z0-9][a-zA-Z0-9\\._-]+@([a-zA-Z0-9\\._-]+\\.)[a-zA-Z-0-9]{2,3}")) {
	    System.out.println("E-mail invalida!");
	    return false;
	}

	if (email.length() > 120) {
	    System.out.println("E-mail deve conter no maximo 120 caracteres!");
	    return false;
	}

	return true;
    }
}
