package projetoTeste.cliente;

import java.util.ArrayList;

public class Dados {

	ArrayList<Cliente> listaClientes = new ArrayList<>();

	public void cadastrarCliente(Cliente cliente) {
		
		listaClientes.add(cliente);

	}

//remover contato pelo nome	
	public void removerCliente(String clienteRemover) {
		if (listaClientes.size() > 0) {
			for (int i = 0; i < this.listaClientes.size(); i++) {
				Cliente removeCliente = this.listaClientes.get(i);
				if (removeCliente.getNome().equals(clienteRemover)) {
					listaClientes.remove(i);
					System.out.println("\tRemovido Com Sucesso");
				} 
			}
		} else {
			System.out.println("\tLista de Cliente Vazia");
		}
	}
	public Cliente pesquisaCliente(String buscaCliente) {
		for (Cliente c : listaClientes) {
			if (c.getNome().equals(buscaCliente) || c.getRg().equals(buscaCliente) || c.getCpf().equals(buscaCliente)){
			
				return c;
			}
		}
		return null;
	}

	public Cliente pesquisaCliente(String buscaRg, String buscaCpf) {
		for (Cliente c : listaClientes) {
			if ( c.getRg().equals(buscaRg) || c.getCpf().equals(buscaCpf)){
			
				return c;
			}
		}
		return null;
	}
	
	public String limitarString(String cpf) {
		
		if (cpf.length() == 14) {
			return cpf;
		}else 
		return null;
		
	}
	

//listar todos os contatos
	public void listarCliente() {
		if (listaClientes.size() >= 1) {
			for (Cliente c : listaClientes) {
				System.out.println(c);
			}

		} else {
			System.out.println("\t LISTA VAZIA");
		}
	}

}
