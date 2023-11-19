package cadastro.model.util;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import cadastrobd.model.PessoaFisica;

public class PessoaFisicaDAO {
	
	public static void incluir(PessoaFisica p) { // inclui
	    try{
	        Statement s = ConectorBD.conexao.createStatement();
            String str = "insert into pessoas_fisica(id, nome, logradouro, contato, estado, telefone, email, cpf) values (" + p.getId() + ",'" + p.getNome() + "','" + p.getLogradouro() + "','" + p.getContato() + "','" + p.getEstado() + "','" +
            		p.getTelefone() + "','" + p.getEmail() + "','" + p.getCpf() +"')"; 
            s.addBatch(str);
            s.executeBatch();
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	}
	
	public static void alterar(PessoaFisica p) { // altera

	    try{
	    	String id1 = p.getId() + "";
	        Statement s = ConectorBD.getConection().createStatement();
	        String str1 = "delete from pessoas_fisica where id =" + id1;
            String str2 = "insert into pessoas_fisica(id, nome, logradouro, contato, estado, telefone, email, cpf) values (" + p.getId() + ",'" + p.getNome() + "','" + p.getLogradouro() + "','" + p.getContato() + "','" + p.getEstado() + "','" +
            		p.getTelefone() + "','" + p.getEmail() + "','" + p.getCpf() +"')"; 
            s.addBatch(str1);
            s.executeBatch();
            s.addBatch(str2);
            s.executeBatch();
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	}
	
	public static void excluir(int id) { // exclui
	    try{
	    	String id1 = id + "";
	        Statement s = ConectorBD.getConection().createStatement();
	        String str1 = "delete from pessoas_fisica where id =" + id1;
            s.addBatch(str1);
            s.executeBatch();
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	}
	
	public static PessoaFisica getPessoa(int id1){ // retorna PessoaFisica por id
		ArrayList<PessoaFisica> pessoasFisica = new ArrayList<PessoaFisica>();
	    String id = "";
	    String nome = "";
	    String logradouro = "";
	    String contato = "";
        String estado = "";
        String telefone = "";
        String email = "";
        String cpf = "";
	    
	    try{
	        ResultSet rsPessoaFisica = ConectorBD.getConection().createStatement().executeQuery("select * from pessoas_fisica");
	        
	        while(rsPessoaFisica.next()){
	        	id = rsPessoaFisica.getString("id");
	        	nome = rsPessoaFisica.getString("nome");
	            logradouro = rsPessoaFisica.getString("logradouro");
	            contato = rsPessoaFisica.getString("contato");
	            estado = rsPessoaFisica.getString("estado");
	            telefone = rsPessoaFisica.getString("telefone");
	            email = rsPessoaFisica.getString("email");
	            cpf = rsPessoaFisica.getString("cpf");
	            pessoasFisica.add(new PessoaFisica(Integer.parseInt(id), nome, logradouro, contato, estado, telefone, email, cpf));
	        }
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    
	    for(PessoaFisica p : pessoasFisica) {
	    	if(p.getId() == id1) {
	    		return p;
	    	}
	    }
	    
	    return new PessoaFisica(-1, "", "","", "", "", "", "");
	}
	
	public static ArrayList<PessoaFisica> getPessoas() { // retorna lista de todas as pessoas fisicas
		ArrayList<PessoaFisica> pessoasFisica = new ArrayList<PessoaFisica>();
	    String id = "";
	    String nome = "";
	    String logradouro = "";
	    String contato = "";
        String estado = "";
        String telefone = "";
        String email = "";
        String cpf = "";
	    
	    try{
	        ResultSet rsPessoaFisica = ConectorBD.getConection().createStatement().executeQuery("select * from pessoas_fisica");
	        
	        while(rsPessoaFisica.next()){
	        	id = rsPessoaFisica.getString("id");
	        	nome = rsPessoaFisica.getString("nome");
	            logradouro = rsPessoaFisica.getString("logradouro");
	            contato = rsPessoaFisica.getString("contato");
	            estado = rsPessoaFisica.getString("estado");
	            telefone = rsPessoaFisica.getString("telefone");
	            email = rsPessoaFisica.getString("email");
	            cpf = rsPessoaFisica.getString("cpf");
	            pessoasFisica.add(new PessoaFisica(Integer.parseInt(id), nome, logradouro, contato, estado, telefone, email, cpf));
	        }
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	
	    return pessoasFisica;
	}
	
	
}
