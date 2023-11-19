package cadastro.model.util;

import java.sql.ResultSet;
import java.sql.Statement;

public class SequenceManeger {
	
	public static int getValue() { // Retorna o ID da proxima pessoa
	    String id = "";
	    
	    try{
	        ResultSet rsUsuarios = ConectorBD.conexao.createStatement().executeQuery("select * from id_sequenpessoas"); // Operação select no banco de dados
	        while(rsUsuarios.next()) {
	        	id = rsUsuarios.getString("id");
	        }
	        int id2 = Integer.parseInt(id);
	        id2++;
	        String id3 = "" + id2;
	        String str = "update id_sequenpessoas set id =" + id3;
	        Statement s = ConectorBD.getConection().createStatement();
            s.addBatch(str);
            s.executeBatch();
	    }catch(Exception e){
	        e.printStackTrace();
	    }

	    return Integer.parseInt(id);
	}
}
