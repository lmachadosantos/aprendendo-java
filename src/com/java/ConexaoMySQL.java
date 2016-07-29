package com.java;

import java.sql.*;

public class ConexaoMySQL {

    public String status = "Não conectou...";

    public java.sql.Connection getConexaoMySQL() {
	
        Connection connection = null; 
        try {
        
            String driverName = "com.mysql.jdbc.Driver";                        
            Class.forName(driverName);
 
            String serverName = "localhost"; 
 
            String mydatabase = "mysql_java";
 
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
 
            String username = "root";   
 
            String password = "123456";
 
	    connection = DriverManager.getConnection(url, username, password);
 
            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
            }

            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
        
    }

    public String statusConection() {
	return status;
    }

    public boolean FecharConexao() {
	try {
	    this.getConexaoMySQL().close();
	    return true;
	} catch (SQLException e) {
	    return false;
	}
    }

    public java.sql.Connection ReiniciarConexao() {
	FecharConexao();
	return this.getConexaoMySQL();
    }
}
