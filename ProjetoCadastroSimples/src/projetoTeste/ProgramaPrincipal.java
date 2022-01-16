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
		System.out.println("Nome");
		nomeCliente = teclado.nextLine();
		
		System.out.println("RG");
		rgCliente = teclado.nextLine();

		System.out.println("CPF");
		cpfCliente = teclado.nextLine();

		System.out.println("E-mail");
		emailCliente = teclado.nextLine();

		System.out.println("Telefone");
		telefoneCliente = teclado.nextLine();
//		Cliente nomeC = dados.pesquisaCliente(nomeCliente, cpfCliente);
		Cliente rg = dados.pesquisaCliente(nomeCliente, rgCliente, cpfCliente);
		Cliente cpf = dados.pesquisaCliente(nomeCliente, rgCliente, cpfCliente);
		if (rg == null && cpf == null) {

			Cliente cliente = new Cliente(nomeCliente, rgCliente, cpfCliente, emailCliente, telefoneCliente);

			dados.cadastrarCliente(cliente);
			System.out.println("\tCADASTRADO COM SUCESSO\n");

		} else
			System.out.println("Falha -> Usuário já cadastrado para outro usuário");

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
		System.out.println("Nome do usuário");
		String usuario = teclado.nextLine();
		Cliente c = dados.pesquisaCliente(usuario);
		if (c != null) {
			System.out.println("\t SELECIONE UMA OPÇÃO");
			System.out.println("[1] - Nome");
			System.out.println("[2] - CPF");
			System.out.println("[3] - E-mail");
			System.out.println("[4] - Telefone");
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
				System.out.println("Cpf Novo:");
				String cpfNovo = teclado.nextLine();
				c.setCpf(cpfNovo);
				break;
			case 3:
				teclado.nextLine();
				System.out.println("E-mail Novo:");
				String emailNovo = teclado.nextLine();
				c.setEmail(emailNovo);
				break;
			case 4:
				teclado.nextLine();
				System.out.println("Telefone Novo:");
				String telefoneNovo = teclado.nextLine();
				c.setTelefone(telefoneNovo);
				break;
			case 5:
				teclado.nextLine();

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