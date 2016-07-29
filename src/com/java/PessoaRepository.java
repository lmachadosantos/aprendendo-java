package com.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PessoaRepository {
    private final String tabela = "UsuarioPessoa";
    private Connection conn;
    private PessoaValidacao pessoaValidacao;

    public PessoaRepository(Connection conexao) {
	this.conn = conexao;
	this.pessoaValidacao = new PessoaValidacao();
    }

    public Pessoa persiste(Pessoa pessoa) throws Exception {
	
	if (!pessoaValidacao.valida(pessoa)) {
	    throw new Exception();
	}
	
	String stmt = "INSERT INTO "
		+ this.tabela
		+ " (usuario_id, nome, email, ativo, criado_em, excluido) VALUES (?, ?, ?, ?, ?, ?)";

	PreparedStatement preparedStmt;

	try {
	    preparedStmt = conn.prepareStatement(stmt,
		    Statement.RETURN_GENERATED_KEYS);
	    preparedStmt.setInt(1, pessoa.getUsuario().getId());
	    preparedStmt.setString(2, pessoa.getNome());
	    preparedStmt.setString(3, pessoa.getEmail());
	    preparedStmt.setBoolean(4, true);
	    preparedStmt.setDate(5, new java.sql.Date(pessoa.getCriadoEm()
		    .getTimeInMillis()));
	    preparedStmt.setBoolean(6, false);

	    preparedStmt.execute();
	    ResultSet result = preparedStmt.getGeneratedKeys();

	    if (result.next()) {
		int last_inserted_id = result.getInt(1);
		pessoa.setId(last_inserted_id);
	    }
	    
	    System.out.println("FOI FILHAO");
	    
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return pessoa;
    }
}
