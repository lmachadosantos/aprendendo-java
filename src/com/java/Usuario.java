package com.java;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

public class Usuario {

    private int id;

    private String login;

    private String senha;

    private boolean ativo;

    private Calendar criadoEm;

    private Calendar atualizadoEm;

    private boolean excluido;

    /**
     * @return the id
     */
    public int getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id) {
	this.id = id;
    }

    /**
     * @return the login
     */
    public String getLogin() {
	return login;
    }

    /**
     * @param login
     *            the login to set
     */
    public void setLogin(String login) {
	this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
	return senha;
    }

    /**
     * @param senha
     *            the senha to set
     */
    public void setSenha(String senha) {
	try {
	    MessageDigest criptografar = MessageDigest.getInstance("SHA");
	    criptografar.update(senha.getBytes());
	    BigInteger hash = new BigInteger(1, criptografar.digest());

	    this.senha = hash.toString(16);
	} catch (NoSuchAlgorithmException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    /**
     * @return the ativo
     */
    public boolean isAtivo() {
	return ativo;
    }

    /**
     * @param ativo
     *            the ativo to set
     */
    public void setAtivo(boolean ativo) {
	this.ativo = ativo;
    }

    /**
     * @return the criadoEm
     */
    public Calendar getCriadoEm() {
	return criadoEm;
    }

    /**
     * @param criadoEm
     *            the criadoEm to set
     */
    public void setCriadoEm(Calendar criadoEm) {
	this.criadoEm = criadoEm;
    }

    /**
     * @return the atualizadoEm
     */
    public Calendar getAtualizadoEm() {
	return atualizadoEm;
    }

    /**
     * @param atualizadoEm
     *            the atualizadoEm to set
     */
    public void setAtualizadoEm(Calendar atualizadoEm) {
	this.atualizadoEm = atualizadoEm;
    }

    /**
     * @return the excluido
     */
    public boolean isExcluido() {
	return excluido;
    }

    /**
     * @param excluido
     *            the excluido to set
     */
    public void setExcluido(boolean excluido) {
	this.excluido = excluido;
    }

}
