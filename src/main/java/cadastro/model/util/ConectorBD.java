package cadastro.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class ConectorBD {
	
	public static Connection conexao = null;
	
	public static Connection getConection() { // retorna conexao
	    
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        conexao = DriverManager.getConnection("jdbc:mysql://localhost/banco2", "root", "marcosph");
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
	    return conexao;
	}
	
	public static Statement getPrapared(String sql) { // prepara um statement
	    Statement s = null;
		
	    try{
	        s = conexao.createStatement();
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
	    return s;
	}
	
	public static ResultSet GetSelect(String sql) { // prepara um ResultSet
		ResultSet rs = null;
		
		try {
			rs = conexao.createStatement().executeQuery(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public static void closeConexao() { // fecha a conexao
		try {
			conexao.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
