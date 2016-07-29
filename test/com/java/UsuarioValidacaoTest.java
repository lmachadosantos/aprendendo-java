package com.java;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsuarioValidacaoTest {

    @Test
    public void testSeValidaLogin() {
	Usuario usuario = new Usuario();
	UsuarioValidacao  usuarioValidacao = new UsuarioValidacao();
	usuario.setSenha("123456");
	
	usuario.setLogin("");
	assertFalse( usuarioValidacao.valida(usuario) );
	
	usuario.setLogin("lmach");
	assertFalse( usuarioValidacao.valida(usuario) );
	
	usuario.setLogin("lmachadodossantos1234");
	assertFalse( usuarioValidacao.valida(usuario) );
	
	usuario.setLogin(null);
	assertFalse( usuarioValidacao.valida(usuario) );
	
	usuario.setLogin("lmacha");
	assertTrue( usuarioValidacao.valida(usuario) );
	
	usuario.setLogin("lmachad");
	assertTrue( usuarioValidacao.valida(usuario) );
	
	usuario.setLogin("lmachadodossantos123");
	assertTrue( usuarioValidacao.valida(usuario) );
	
	usuario.setLogin("lmachadodossantos12");
	assertTrue( usuarioValidacao.valida(usuario) );
	
    }

}
