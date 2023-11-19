package cadastro.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PessoasDAO {
	
	public static int retornaIdSequenPessoas() {
	    Connection conexao = null;
	    String id = "";
	    
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver"); // Conector do banco de dados sql
	        conexao = DriverManager.getConnection("jdbc:mysql://localhost/bancomissao2", "root", "marcosph"); // Conecta ao banco
	        ResultSet rsUsuarios = conexao.createStatement().executeQuery("select * from id_sequenpessoas");
	        while(rsUsuarios.next()) {
	        	id = rsUsuarios.getString("id");
	        }
	        int id2 = Integer.parseInt(id);
	        id2++;
	        String id3 = "" + id2;
	        String str = "update id_sequenusuarios set id =" + id3;
	        Statement s = conexao.createStatement();
            s.addBatch(str);
            s.executeBatch();
	    }catch(ClassNotFoundException e){
	        System.out.println("Driver do banco de dados nao localizado");
	    }catch(SQLException s){
	       s.printStackTrace();
	    }

	    return Integer.parseInt(id);
	}
}
