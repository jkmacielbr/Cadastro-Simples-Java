package projetoTeste.cliente;

public class Cliente {
	private String nome;
	private String rg;
	private String cpf;
	private String email;
	private String telefone;
	
	public Cliente() {

	}


	public Cliente(String nome, String rg, String cpf, String email, String telefone) {
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
	}

	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Nome:" + this.nome + "\t RG:" + this.rg + "\t CPF:" + this.cpf + "\t E-mail:" + this.email + " \tTelefone:"
				+ this.telefone;
	}

}
