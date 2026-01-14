package com.kaua.estoque.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String URL = "jdbc:mysql://localhost:3306/estoque";
	private static final String USER = "root";
	private static final String PASS = "0402";
	
	public static Connection getConnection() {
		try {	
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao conectar com o banco", e);
		}
	}
}
