package cadastrobd.model;

import sistemadevendas.Pessoa;

public class PessoaJuridica extends Pessoa{

	private String cnpj; // Atributo cnpj
	
	public PessoaJuridica(int id, String nome, String logradouro, String cidade, String estado, String telefone, String email, String cnpj) {
		super(id, nome, logradouro, cidade, estado, telefone, email);
		this.cnpj = cnpj;
	}

	public String getCnpj() { // Método get e set
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@Override
	public void exibir() { //exibe
		System.out.println("--------------------");
		System.out.println("ID: " + getId() + "\n" + "NOME: " + getNome() + "\n" + "LOGRADOURO: " + getLogradouro() + "\n" + "CIDADE: " + getCidade() + "\n" + "ESTADO: " + getEstado() + "\n" + "TELEFONE: " + getTelefone() + "\n" + "EMAIL: " + getEmail() + "\n" + "CNPJ: " + cnpj);
		System.out.println("--------------------");
	}
}
