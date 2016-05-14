package br.edu.iesp.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static final String DRIVE_CLASS = "org.hsqldb.jdbcDriver";
	private static Connection conn = null;
	private static String usuario = "SA";
	private static String senha = "";
	private static String PathBase = "C:\\Users\\arthur\\Dropbox\\WebP-6\\project-pweb\\basededados\\dados";
	private static final String URL = "jdbc:hsqldb:file:" + PathBase/* + ";shutdown=true;hsqldb.write_delay=false; "*/;

	public static Connection conectar() {
		if (conn == null) {
			try {
				Class.forName(DRIVE_CLASS);
				// Estabelecendo a coneção
				conn = DriverManager.getConnection(URL, usuario, senha);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return conn;
	}

	public static void fecharcnx() {

		try {
			conn.close();
			conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	
}
