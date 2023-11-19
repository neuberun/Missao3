package sistemadevendas;

public class Pessoa {
	//Atributos
	private int id;
	private String nome;
	private String logradouro;
	private String cidade;
	private String estado;
	private String telefone;
	private String email;
	
	public Pessoa(int id, String nome, String logradouro, String contato, String estado, String telefone, String email) { // Método construtor
		this.id = id;
		this.nome = nome;
		this.logradouro = logradouro;
		this.cidade = contato;
		this.estado = estado;
		this.telefone = telefone;
		this.email = email;
	}
	
	public int getId() { // Métodos get e set
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getLocalizacao() {
		return logradouro;
	}
	
	public void setLocalizacao(String localizacao) {
		this.logradouro = localizacao;
	}
	
	public String getContato() {
		return cidade;
	}
	
	public void setContato(String contato) {
		this.cidade = contato;
	}
	

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void exibir() { // exibe
		System.out.println("--------------------");
		System.out.println("ID: " + id + "\n" + "NOME: " + nome + "\n" + "LOGRADOURO: " + logradouro + "\n" + "CIDADE: " + cidade + "\n" + "ESTADO: " + estado + "\n" + "TELEFONE: " + telefone + "\n" + "EMAIL: " + email);
		System.out.println("--------------------");
	}
}
