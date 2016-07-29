package com.java;

import java.util.Calendar;

public class Pessoa {

    private int id;

    private Usuario usuario;

    private String nome;

    private String email;

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
     * @return the usuario
     */
    public Usuario getUsuario() {
	return usuario;
    }

    /**
     * @param usuario
     *            the usuario to set
     */
    public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
    }

    /**
     * @return the nome
     */
    public String getNome() {
	return nome;
    }

    /**
     * @param nome
     *            the nome to set
     */
    public void setNome(String nome) {
	this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
	return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
	this.email = email;
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
