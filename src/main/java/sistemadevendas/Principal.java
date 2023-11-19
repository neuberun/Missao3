package sistemadevendas;

import java.util.Scanner;



import cadastro.model.util.ConectorBD;
import cadastro.model.util.PessoaFisicaDAO;
import cadastro.model.util.PessoaJuridicaDAO;
import cadastro.model.util.SequenceManeger;
import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaJuridica;

public class Principal { // Classe main
	public static void main(String args[]) {
		boolean sair = false;
		Scanner scan = new Scanner(System.in);
		ConectorBD.getConection(); /// inicia a conexao em conectorBD
		
		while(!sair) {
			
			System.out.println("1 - INCLUIR\n" + "2 - ALTERAR\n"
			+ "3 - EXCLUIR\n" + "4 - EXIBIR\n" + "5 - EXIBIR TODOS\n" 
			+ "6 - SAIR");
			
			int opc = scan.nextInt();
			scan.nextLine();
			if(opc == 6) {
				sair = true;
				break;
			}
			
			System.out.println("F - PESSOA FISICA, J - PESSOA JURIDICA");
			String str = scan.nextLine();
			
		switch(opc) {	
			case 1:	// Inclui			
					if(str.equalsIgnoreCase("F")) {
						int id = SequenceManeger.getValue();
						System.out.print("DIGITE O NOME DA PESSOA FISICA: ");
						String nome = scan.nextLine();
						System.out.print("DIGITE O LOGRADOURO: ");
						String logradouro = scan.nextLine();
						System.out.print("CONTATO: ");
						String contato = scan.nextLine();
						System.out.print("ESTADO: ");
						String estado = scan.nextLine();
						System.out.print("TELEFONE: ");
						String telefone = scan.nextLine();
						System.out.print("EMAIL: ");
						String email = scan.nextLine();
						System.out.print("CPF: ");
						String cpf = scan.nextLine();
						PessoaFisicaDAO.incluir(new PessoaFisica(id, nome, logradouro, contato, estado, telefone, email, cpf));
					} else if(str.equalsIgnoreCase("J")){
						int id = SequenceManeger.getValue();
						System.out.print("DIGITE O NOME DA PESSOA JURIDICA: ");
						String nome = scan.nextLine();
						System.out.print("DIGITE O LOGRADOURO: ");
						String logradouro = scan.nextLine();
						System.out.print("CONTATO: ");
						String contato = scan.nextLine();
						System.out.print("ESTADO: ");
						String estado = scan.nextLine();
						System.out.print("TELEFONE: ");
						String telefone = scan.nextLine();
						System.out.print("EMAIL: ");
						String email = scan.nextLine();
						System.out.print("CNPJ: ");
						String cnpj = scan.nextLine();
						PessoaJuridicaDAO.incluir(new PessoaJuridica(id, nome, logradouro, contato, estado, telefone, email, cnpj));
					}
					break;
					
			case 2: // Altera
					if(str.equalsIgnoreCase("F")) {
						System.out.print("DIGITE O ID: ");
						int id2 = scan.nextInt();
						scan.nextLine();
						System.out.print("DIGITE O NOME DA PESSOA: ");
						String nome2 = scan.nextLine();
						System.out.print("DIGITE O LOGRADOURO: ");
						String logradouro2 = scan.nextLine();
						System.out.print("CONTATO: ");
						String contato2 = scan.nextLine();
						System.out.print("ESTADO: ");
						String estado2 = scan.nextLine();
						System.out.print("TELEFONE: ");
						String telefone2 = scan.nextLine();
						System.out.print("EMAIL: ");
						String email2 = scan.nextLine();
						System.out.print("CPF: ");
						String cpf = scan.nextLine();
						PessoaFisicaDAO.alterar(new PessoaFisica(id2, nome2, logradouro2, contato2, estado2, telefone2, email2, cpf));
					} else if(str.equalsIgnoreCase("J")){
						System.out.print("DIGITE O ID: ");
						int id2 = scan.nextInt();
						scan.nextLine();
						System.out.print("DIGITE O NOME DA PESSOA: ");
						String nome2 = scan.nextLine();
						System.out.print("DIGITE O LOGRADOURO: ");
						String logradouro2 = scan.nextLine();
						System.out.print("CONTATO: ");
						String contato2 = scan.nextLine();
						System.out.print("ESTADO: ");
						String estado2 = scan.nextLine();
						System.out.print("TELEFONE: ");
						String telefone2 = scan.nextLine();
						System.out.print("EMAIL: ");
						String email2 = scan.nextLine();
						System.out.print("CNPJ: ");
						String cnpj = scan.nextLine();
						PessoaJuridicaDAO.alterar(new PessoaJuridica(id2, nome2, logradouro2, contato2, estado2, telefone2, email2, cnpj));
					}
					break;
					
			case 3: // exclui pelo id
					System.out.print("DIGITE O ID: ");
					int id3 = scan.nextInt();
					
					if(str.equalsIgnoreCase("F")) {
						PessoaFisicaDAO.excluir(id3);
					} else if(str.equalsIgnoreCase("J")) {
						PessoaJuridicaDAO.excluir(id3);
					}
					break;
					
			case 4: // retorna pelo id
					System.out.print("DIGITE O ID: ");
					int id1 = scan.nextInt();
					if(str.equalsIgnoreCase("F")) {
						if(PessoaFisicaDAO.getPessoa(id1).getId() != -1) {
							PessoaFisicaDAO.getPessoa(id1).exibir();
						}
					} else if(str.equalsIgnoreCase("J")) {
						if(PessoaJuridicaDAO.getPessoa(id1).getId() != -1) {
							PessoaJuridicaDAO.getPessoa(id1).exibir();
						}
					}
					break;
					
			case 5: // retorna todos
					if(str.equalsIgnoreCase("F")) {
						for(PessoaFisica f : PessoaFisicaDAO.getPessoas()) {
							f.exibir();
						}
					} else if(str.equalsIgnoreCase("J")) {
						for(PessoaJuridica j : PessoaJuridicaDAO.getPessoas()) {
							j.exibir();
						}
					}
					break;
			}
		}
		scan.close();
		ConectorBD.closeConexao(); // encerra a conexao
	}
}
