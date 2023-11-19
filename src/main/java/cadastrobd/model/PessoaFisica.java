package cadastrobd.model;

import sistemadevendas.Pessoa;

public class PessoaFisica extends Pessoa {
	
	private String cpf; // Atributo
	
	// Método construtor
	public PessoaFisica(int id, String nome, String logradouro, String contato, String estado, String telefone, String email, String cpf) {
		super(id, nome, logradouro, contato, estado, telefone, email);
		this.cpf = cpf;
	}

	public String getCpf() { // Método get e set
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public void exibir() { // exibe
		System.out.println("--------------------");
		System.out.println("ID: " + getId() + "\n" + "NOME: " + getNome() + "\n" + "LOGRADOURO: " + getLogradouro() + "\n" + "CIDADE: " + getCidade() + "\n" + "ESTADO: " + getEstado() + "\n" + "TELEFONE: " + getTelefone() + "\n" + "EMAIL: " + getEmail() + "\n" + "CPF: " + cpf);
		System.out.println("--------------------");
	}
}
