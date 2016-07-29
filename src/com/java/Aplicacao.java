package com.java;

import java.util.Calendar;

public class Aplicacao {

    public static void main(String[] args) {
	ConexaoMySQL conn = new ConexaoMySQL();

	Usuario usuario = new Usuario();
	UsuarioRepository usuarioRepository = new UsuarioRepository(
		conn.getConexaoMySQL());

	usuario.setLogin("diedolol");
	usuario.setSenha("123456");
	usuario.setCriadoEm(Calendar.getInstance());

	try {
	    usuarioRepository.persiste(usuario);
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	Pessoa pessoa = new Pessoa();
	PessoaRepository pessoaRepository = new PessoaRepository(
		conn.getConexaoMySQL());

	pessoa.setUsuario(usuario);
	pessoa.setNome("Leandro Machado dos Santos");
	pessoa.setEmail("lmachadosantos@icloud.com");
	pessoa.setCriadoEm(Calendar.getInstance());

	try {
	    pessoaRepository.persiste(pessoa);
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	System.out.println("VAI FILHAO");
	System.out.println(conn.statusConection());

    }
}
