package projetoTeste;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


import projetoTeste.cliente.Cliente;

public class Programa {

	public static void main(String[] args) {
		
		
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		Cliente cliente = new Cliente();
		
		Scanner teclado = new Scanner (System.in);
		System.out.println("Digite um nome:");
		String nome = teclado.nextLine();
		System.out.println("Digite o cpf:");
		String cpf = teclado.nextLine();
		System.out.println("Digite um e-mail:");
		String email = teclado.nextLine();
		System.out.println("Digite número de telefone:");
		String telefone = teclado.nextLine();
		
		
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setEmail(email);
		cliente.setTelefone(telefone);
		lista.add(cliente);
		
		teclado.nextLine();
		System.out.println("Digite um nome:");
		String nome1 = teclado.nextLine();
		System.out.println("Digite o cpf:");
		String cpf1 = teclado.nextLine();
		System.out.println("Digite um e-mail:");
		String email1 = teclado.nextLine();
		System.out.println("Digite número de telefone:");
		String telefone1 = teclado.nextLine();
		
		cliente.setNome(nome1);
		cliente.setCpf(cpf1);
		cliente.setEmail(email1);
		cliente.setTelefone(telefone1);
		lista.add(cliente);
		
		
	
		int i = 0;
	    Iterator<Cliente> iterator = lista.iterator();
	    while (iterator.hasNext()) {
	      System.out.printf("Posição %d- %s\n", i, iterator.next());
	      i++;
	    }
		
		
		
		teclado.close();
		

	}

}
