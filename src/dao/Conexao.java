package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private Connection conn; //Connection => classe
	
	public Conexao() {	
		
		try {
			setConn(DriverManager.getConnection("jdbc:mysql://localhost:3308/mydb", "root", "qwert123"));
		} catch (SQLException e) {
			// TODO Bloco catch gerado automaticamente
			e.printStackTrace();
		}
		
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
}

