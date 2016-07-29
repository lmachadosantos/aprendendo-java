package com.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioRepository {

    private final String tabela = "Usuario";
    private Connection conn;
    private UsuarioValidacao usuarioValidacao;

    public UsuarioRepository(Connection conexao) {
	this.conn = conexao;
	this.usuarioValidacao = new UsuarioValidacao();
    }

    public Usuario persiste(Usuario usuario) throws Exception {

	if (!usuarioValidacao.valida(usuario)) {
	    throw new Exception();
	}

	String stmt = "INSERT INTO "
		+ this.tabela
		+ " (login, senha, ativo, criado_em, excluido) VALUES (?, ?, ?, ?, ?)";

	PreparedStatement preparedStmt;

	try {
	    preparedStmt = conn.prepareStatement(stmt,
		    Statement.RETURN_GENERATED_KEYS);
	    preparedStmt.setString(1, usuario.getLogin());
	    preparedStmt.setString(2, usuario.getSenha());
	    preparedStmt.setBoolean(3, true);
	    preparedStmt.setDate(4, new java.sql.Date(usuario.getCriadoEm()
		    .getTimeInMillis()));
	    preparedStmt.setBoolean(5, false);

	    preparedStmt.execute();
	    ResultSet result = preparedStmt.getGeneratedKeys();

	    if (result.next()) {
		int last_inserted_id = result.getInt(1);
		usuario.setId(last_inserted_id);
	    }
	    System.out.println("FOI FILHAO");

	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return usuario;
    }

}
