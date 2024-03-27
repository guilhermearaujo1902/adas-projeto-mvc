package br.com.projetoMvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionFactory {
	
	public static final String PATH = "jdbc:postgresql://localhost:5432/db_adas";
	public static final String USER = "postgres";
	public static final String PASSWORD = "admin";
	
	/**
	 * Método responsável por abrir conexão com banco
	 * @return retorn objeto da classe Connection
	 * */
	public static Connection getConnection() throws Exception {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(PATH, USER, PASSWORD);
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws Exception {
		close(conn, stmt, rs);
	}
	
	public static void closeConnection(Connection conn, Statement stmt) throws Exception {
		close(conn, stmt, null);
	}
	
	public static void closeConnection(Connection conn) throws Exception {
		close(conn, null, null);
	}
	
	// Método responsável por fechar a conexão de um dos objetos por parâmetro
	private static void close(Connection conn, Statement stmt, ResultSet rs) throws Exception {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
