package construtores;
/**
 * Classe de construção e manipulação de ojetos tipo Cliente.
 */
public class Cliente{ 
	
	private String nome;
	private String cpf; 
	private String cnh;
	private Endereco endereco;
	private String telefone;

	public Cliente(String nome, String cpf, String cnh, String telefone, 
			String rua, String numero, String complemento, String bairro, 
			String cidade, String cep) {
		this.nome = nome;
		this.cpf = cpf;
		this.cnh = cnh;
		this.endereco = new Endereco(rua, bairro, numero, complemento, cidade, cep);
		this.telefone = telefone;

	}
	
	//geters
	public String getNome() {return nome;}
	public String getCpf() {return cpf;}
	public String getCnh() {return cnh;}
	public Endereco getEndereco() {return endereco;}
	public String getTelefone() {return telefone;}
	
	//seters
	public void setNome(String nome) {this.nome = nome;}
	public void setCpf(String cpf) {this.cpf = cpf;}
	public void setCnh(String cnh) {this.cnh = cnh;}
	public void setEndereco(Endereco endereco) {this.endereco = endereco;}
	public void setTelefone(String telefone) {this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Cliente [ Nome: " + nome + ", CPF: " + cpf + ", CNH: " + cnh +
				", Endereço: " + endereco.toString() + ", Telefone: " + telefone + " ]";
	}
	
	public String confirmacaoDados() {
		return "Nome: "+ nome + "\n" + "CPF: " + cpf + "\n" + "CNH: " + cnh +"\n" +
				"Endereço: " + endereco.toString() + "\n" + "Telefone: " + telefone + "\n";
	}
	
	
	

}
