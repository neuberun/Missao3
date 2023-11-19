package cadastro.model.util;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import cadastrobd.model.PessoaJuridica;

public class PessoaJuridicaDAO {
	
	public static void incluir(PessoaJuridica p) { // incluir
	    try{
	        Statement s = ConectorBD.getConection().createStatement();
            String str = "insert into pessoas_juridica(id, nome, logradouro, contato, estado, telefone, email, cnpj) values (" + p.getId() + ",'" + p.getNome() + "','" + p.getLogradouro() + "','" + p.getContato() + "','" + p.getEstado() + "','" +
            		p.getTelefone() + "','" + p.getEmail() + "','" + p.getCnpj() +"')"; 
            s.addBatch(str);
            s.executeBatch();
	    }catch(Exception e){
	       e.printStackTrace();
	    }
	}
	
	public static void alterar(PessoaJuridica p) { // alterar

	    try{
	    	String id1 = p.getId() + "";
	        Statement s = ConectorBD.getConection().createStatement();
	        String str1 = "delete from pessoas_juridica where id =" + id1;
            String str2 = "insert into pessoas_juridica(id, nome, logradouro, contato, estado, telefone, email, cnpj) values (" + p.getId() + ",'" + p.getNome() + "','" + p.getLogradouro() + "','" + p.getContato() + "','" + p.getEstado() + "','" +
            		p.getTelefone() + "','" + p.getEmail() + "','" + p.getCnpj() +"')"; 
            s.addBatch(str1);
            s.executeBatch();
            s.addBatch(str2);
            s.executeBatch();
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	}
	
	public static void excluir(int id) { // excluir
	    try{
	    	String id1 = id + "";
	        Statement s = ConectorBD.getConection().createStatement();
	        String str1 = "delete from pessoas_juridica where id =" + id1;
            s.addBatch(str1);
            s.executeBatch();
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	}
	
	public static PessoaJuridica getPessoa(int id1){ //retorna 1 PessoaJuridica pelo ID
		ArrayList<PessoaJuridica> pessoasJuridica = new ArrayList<PessoaJuridica>();
	    String id = "";
	    String nome = "";
	    String logradouro = "";
	    String contato = "";
        String estado = "";
        String telefone = "";
        String email = "";
        String cnpj = "";
	    
	    try{
	        ResultSet rsPessoaJuridica = ConectorBD.getConection().createStatement().executeQuery("select * from pessoas_juridica");
	        
	        while(rsPessoaJuridica.next()){
	        	id = rsPessoaJuridica.getString("id");
	        	nome = rsPessoaJuridica.getString("nome");
	            logradouro = rsPessoaJuridica.getString("logradouro");
	            contato = rsPessoaJuridica.getString("contato");
	            estado = rsPessoaJuridica.getString("estado");
	            telefone = rsPessoaJuridica.getString("telefone");
	            email = rsPessoaJuridica.getString("email");
	            cnpj = rsPessoaJuridica.getString("cnpj");
	            pessoasJuridica.add(new PessoaJuridica(Integer.parseInt(id), nome, logradouro, contato, estado, telefone, email, cnpj));
	        }
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	    
	    for(PessoaJuridica p : pessoasJuridica) {
	    	if(p.getId() == id1) {
	    		return p;
	    	}
	    }
	    
	    return new PessoaJuridica(-1, "", "","", "", "", "", "");
	}
	
	public static ArrayList<PessoaJuridica> getPessoas() { // retorna uma lista de PessoaJuridica
		ArrayList<PessoaJuridica> pessoasJuridica = new ArrayList<PessoaJuridica>();
	    String id = "";
	    String nome = "";
	    String logradouro = "";
	    String contato = "";
        String estado = "";
        String telefone = "";
        String email = "";
        String cnpj = "";
	    
	    try{
	        ResultSet rsPessoaJuridica = ConectorBD.getConection().createStatement().executeQuery("select * from pessoas_juridica");
	        
	        while(rsPessoaJuridica.next()){
	        	id = rsPessoaJuridica.getString("id");
	        	nome = rsPessoaJuridica.getString("nome");
	            logradouro = rsPessoaJuridica.getString("logradouro");
	            contato = rsPessoaJuridica.getString("contato");
	            estado = rsPessoaJuridica.getString("estado");
	            telefone = rsPessoaJuridica.getString("telefone");
	            email = rsPessoaJuridica.getString("email");
	            cnpj = rsPessoaJuridica.getString("cnpj");
	            pessoasJuridica.add(new PessoaJuridica(Integer.parseInt(id), nome, logradouro, contato, estado, telefone, email, cnpj));
	        }
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	
	    return pessoasJuridica;
	}
	
	
}
