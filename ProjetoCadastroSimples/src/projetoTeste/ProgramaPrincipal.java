package projetoTeste;

import java.util.Scanner;

import projetoTeste.cliente.Cliente;
import projetoTeste.cliente.Dados;

public class ProgramaPrincipal {

	private static Scanner teclado;

	public static void main(String[] args) {

		int resposta = -1;
		Dados dados = new Dados();

		Scanner teclado = new Scanner(System.in);

		do {
			MostraMenu();
			resposta = teclado.nextInt();

			switch (resposta) {
			case 1:
				menuCadastro(teclado, dados);
				System.out.println("Digite qualquer tecla para voltar menu inicial");
				teclado.next();
				break;

			case 2:
				dadosListar(dados);

				break;
			case 3:
				removerCliente(dados);

				break;

			case 4:
				System.out.println("Digite Nome RG ou CPF do usuário que você quer pesquisar");

				teclado.nextLine();

				String buscarUsuario = teclado.nextLine();

				Cliente cliente = dados.pesquisaCliente(buscarUsuario);
				if (cliente != null) {
					System.out.println("Usuário encontrado\n" + cliente.toString());

				} else
					System.out.println("Não Existe");

				break;
			case 5:
				menuAlterarDados(dados);

			}

		} while (resposta != 0);

	}

	public static void MostraMenu() {
		System.out.println("\t\tBem vindo");
		System.out.print("[1] - Cadastro");
		System.out.print("\t[3] - Excluir");
		System.out.println("\t[5] - Alterar Dados");
		System.out.print("[2] - Listar");
		System.out.print("\t[4] - Pesquisar");
		System.out.println("\t[0] - Sair");

	}

	public static void menuCadastro(Scanner teclado, Dados dados) {

		String nomeCliente;
		String rgCliente;
		String cpfCliente;
		String emailCliente;
		String telefoneCliente;

		teclado.nextLine();
		System.out.println("Informe um Nome");
		nomeCliente = teclado.nextLine();
		
		System.out.println("Informe um RG");
		rgCliente = teclado.nextLine();

		System.out.println("Informe o CPF");
		cpfCliente = teclado.nextLine();

		System.out.println("Informe um E-mail");
		emailCliente = teclado.nextLine();

		System.out.println("Telefone");
		telefoneCliente = teclado.nextLine();
		
		if(dados.limitarString(cpfCliente) != null) {
		
		String d1, d2, d3, d4, d5, d6, d7, d8, d9 , confere = "";
		int n1, n2 , n3 , n4, n5 , n6, n7, n8, n9, verificador1, verificador2;
		d1 = (String) cpfCliente.subSequence(0, 1); n1 = Integer.parseInt(d1);
		d2 = (String) cpfCliente.subSequence(1, 2); n2 = Integer.parseInt(d2);
		d3 = (String) cpfCliente.subSequence(2, 3); n3 = Integer.parseInt(d3);
		d4 = (String) cpfCliente.subSequence(4, 5); n4 = Integer.parseInt(d4);
		d5 = (String) cpfCliente.subSequence(5, 6); n5 = Integer.parseInt(d5);
		d6 = (String) cpfCliente.subSequence(6, 7); n6 = Integer.parseInt(d6);
		d7 = (String) cpfCliente.subSequence(8, 9); n7 = Integer.parseInt(d7);
		d8 = (String) cpfCliente.subSequence(9, 10); n8 = Integer.parseInt(d8);
		d9 = (String) cpfCliente.subSequence(10, 11); n9 = Integer.parseInt(d9);
		
	
		verificador1 = (n1 * 10+ n2 * 9 + n3 * 8 + n4 *7 + n5 * 6 + n6 * 5 + n7 * 4 + n8 * 3 + n9 * 2);
		
		if (verificador1 % 11 < 2) {
			verificador1 = 0;
		} else {
			verificador1= 11 - (verificador1 % 11);
		}
		
			verificador2 = (n1 * 11 + n2 * 10 + n3 * 9 + n4 * 8 + n5 * 7 + n6 * 6 + n7 * 5 + n8 * 4 + n9 * 3 + verificador1 * 2);
			if (verificador2 % 11 < 2) {
				verificador2 = 0;
			} else {
				verificador2 = 11 - (verificador2 % 11);
			}
			
		
//			confere = d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + verificador1 + verificador2;
			confere = d1 + d2 + d3 + "." + d4 + d5 + d6 + "." + d7 + d8 + d9 + "-" + verificador1 + verificador2;
			
			
			
			if (confere.equals(cpfCliente)) {
				
								
				Cliente rg = dados.pesquisaCliente(rgCliente, cpfCliente);
				Cliente cpf = dados.pesquisaCliente(rgCliente, cpfCliente);
				if (rg == null && cpf == null) {

					Cliente cliente = new Cliente(nomeCliente, rgCliente, cpfCliente, emailCliente, telefoneCliente);

					dados.cadastrarCliente(cliente);
					System.out.println("\tCADASTRADO COM SUCESSO\n");

				} else
					System.out.println("Falha -> Usuário já cadastrado para outro usuário");
			}
			}else System.out.println("CPF Inválido");
		

	}

	public static void removerCliente(Dados dados) {
		teclado = new Scanner(System.in);
		System.out.println("Digite o nome que deseja remover");
		String removeNome = teclado.nextLine();
		dados.removerCliente(removeNome);
		System.out.println("Digite qualquer tecla para voltar menu inicial");
		teclado.next();
	}

	public static void menuAlterarDados(Dados dados) {
		teclado = new Scanner(System.in);
		dados.listarCliente();
		System.out.println("Digite o RG OU CPF");
		String cpfouRg = teclado.nextLine();
		Cliente c = dados.pesquisaCliente(cpfouRg, cpfouRg);
		if (c != null) {
			System.out.println("\t SELECIONE UMA OPÇÃO");
			System.out.println("[1] - Nome");
			System.out.println("[2] - RG");
			System.out.println("[3] - CPF");
			System.out.println("[4] - E-mail");
			System.out.println("[5] - Telefone");
			System.out.println("[0] - Sair");

			int op = teclado.nextInt();

			switch (op) {
			case 1:
				teclado.nextLine();
				System.out.println("Nome Novo:");
				String nomeNovo = teclado.nextLine();
				c.setNome(nomeNovo);
				break;
			case 2:
				teclado.nextLine();
				System.out.println("RG Novo:");
				String rgNovo = teclado.nextLine();
				c.setRg(rgNovo);
				break;
				
			case 3:
				teclado.nextLine();
				System.out.println("Cpf Novo:");
				String cpfNovo = teclado.nextLine();
				c.setCpf(cpfNovo);
				break;
			case 4:
				teclado.nextLine();
				System.out.println("E-mail Novo:");
				String emailNovo = teclado.nextLine();
				c.setEmail(emailNovo);
				break;
			case 5:
				teclado.nextLine();
				System.out.println("Telefone Novo:");
				String telefoneNovo = teclado.nextLine();
				c.setTelefone(telefoneNovo);
				break;

			}
		} else
			System.out.println("Não cadastrado");

	}

	public static void dadosListar(Dados dados) {
		teclado = new Scanner(System.in);

		dados.listarCliente();
		System.out.println("[1] - Cadastrar um novo usuário");
		System.out.println("[2] - Excluir um usuário");
		System.out.println("[3] - Alterar um usuário");
		int op1 = teclado.nextInt();

		if (op1 == 1) {
			menuCadastro(teclado, dados);

		} else if (op1 == 2) {
			removerCliente(dados);

		} else if (op1 == 3) {
			menuAlterarDados(dados);

		} else
			System.out.println("Opção Invalida");
	}

}