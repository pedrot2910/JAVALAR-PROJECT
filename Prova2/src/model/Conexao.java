package model;

import java.sql.Connection;

public class Conexao {

	private String host;
	private String user;
	private String password;
	private String database;
	
	public Conexao() {
		this.host = "da_java.mysql.dbaas.com.br";
		this.database = "da_java";
		this.user = "da_java";
		this.password = "Tecnicas*2023@";
	}
	
	public Connection getConexao() {
		String url ="jdbc:mysql://" + this.host + ":3306/" + this.database + ""
		
		
		return null;
	}
	
}
