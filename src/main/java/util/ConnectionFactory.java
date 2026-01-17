	package util;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	
	public class ConnectionFactory {
		
		public static Connection getConnection() {
			
			Connection conexao = null;
			
		    try {
		        Class.forName("com.mysql.cj.jdbc.Driver"); 
		        
		        String url = "jdbc:mysql://localhost:3306/estoque?useSSL=false&serverTimezone=UTC";
		        
		        conexao = DriverManager.getConnection(url, "root", "0402");
		       
		    } catch (SQLException ex) {
		       System.out.println("Erro ao abrir a conexao");
		       throw new RuntimeException("Erro ao abrir conexao", ex);
		    }catch (Exception e) {
				System.out.println("Erro ao abrir a conexao");
				throw new RuntimeException("Erro ao registrar driver do JDBC", e);
			}
		    return conexao;
		}
	}
