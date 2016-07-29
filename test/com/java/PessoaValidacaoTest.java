package com.java;

import static org.junit.Assert.*;

import org.junit.Test;

public class PessoaValidacaoTest {
    
    @Test
    public void testSeValidaNome() {
	Pessoa pessoa = new Pessoa();
	PessoaValidacao  pessoaValidacao = new PessoaValidacao();
	
	Usuario usuario = new Usuario();
	usuario.setId(1);
	
	pessoa.setUsuario(usuario);
	pessoa.setEmail("lmachadosantos@gmail.com");
	
	pessoa.setNome(null);
	assertFalse( pessoaValidacao.valida(pessoa) );
	
	pessoa.setNome("");
	assertFalse( pessoaValidacao.valida(pessoa) );
	
	pessoa.setNome("lmach");
	assertFalse( pessoaValidacao.valida(pessoa) );
	
	pessoa.setNome("lmachadodossantos1234lmachadodossantos1234lmachadodossantos1234lmachadodossantos1234lmachadodossantos1234lmachadodossanto");
	assertFalse( pessoaValidacao.valida(pessoa) );
	
	pessoa.setNome("lmacha");
	assertTrue( pessoaValidacao.valida(pessoa) );
	
	pessoa.setNome("lmachad");
	assertTrue( pessoaValidacao.valida(pessoa) );
	
	pessoa.setNome("lmachadodossantos1234lmachadodossantos1234lmachadodossantos1234lmachadodossantos1234lmachadodossantos1234lmachadodossant");
	assertTrue( pessoaValidacao.valida(pessoa) );
	
	pessoa.setNome("lmachadodossantos1234lmachadodossantos1234lmachadodossantos1234lmachadodossantos1234lmachadodossantos1234lmachadodossan");
	assertTrue( pessoaValidacao.valida(pessoa) );
    }
    
    @Test
    public void testSeValidaUsuario() {
	Pessoa pessoa = new Pessoa();
	PessoaValidacao  pessoaValidacao = new PessoaValidacao();
	
	Usuario usuario = new Usuario();
	
	pessoa.setNome("Leandro Machado");
	pessoa.setEmail("lmachadosantos@icloud.com");
	
	usuario.setId(-0);
	pessoa.setUsuario(usuario);
	assertFalse( pessoaValidacao.valida(pessoa) );
	
	usuario.setId(0);
	pessoa.setUsuario(usuario);
	assertFalse( pessoaValidacao.valida(pessoa) );
	
	usuario.setId(1);
	pessoa.setUsuario(usuario);
	assertTrue( pessoaValidacao.valida(pessoa) );
    }
    
    
    @Test
    public void testSeValidaEmail() {
	Pessoa pessoa = new Pessoa();
	PessoaValidacao  pessoaValidacao = new PessoaValidacao();
	
	Usuario usuario = new Usuario();
	usuario.setId(1);
	
	pessoa.setUsuario(usuario);
	pessoa.setNome("Leandro Machado");
	
	pessoa.setEmail(null);
	assertFalse( pessoaValidacao.valida(pessoa) );
	
	pessoa.setEmail("");
	assertFalse( pessoaValidacao.valida(pessoa) );
	
	pessoa.setEmail("lmach");
	assertFalse( pessoaValidacao.valida(pessoa) );
	
	pessoa.setEmail("lmachadodossantos1234lmachadodossantos1234lmachadodossantos1234lmachadodossantos1234lmachadodossantos1234lmachadodossanto");
	assertFalse( pessoaValidacao.valida(pessoa) );
	
	pessoa.setEmail("lmachadosantosicloud.com.br");
	assertFalse( pessoaValidacao.valida(pessoa) );
	
	pessoa.setEmail("lmachadosantos@icloud.com.br");
	assertTrue( pessoaValidacao.valida(pessoa) );
	
	pessoa.setEmail("lmachadosantos@icloud.com");
	assertTrue( pessoaValidacao.valida(pessoa) );
    }
}
