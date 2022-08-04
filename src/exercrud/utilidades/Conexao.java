package exercrud.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//acesso ao banco de dados:

public class Conexao {
	public static Connection con = null;
	public static Connection conectar() {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String senha = "697457";
		try {
			con = DriverManager.getConnection(url, user, senha);
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	public static void fechar() {
		con = null;
	}
	
}
