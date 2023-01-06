package construtores;


public class Endereco {

	private String rua; 
	private String bairro;
	private String numero;
	private String complemento;
	private String cidade;
	private String cep;
	
	public Endereco(String rua, String bairro, String numero, String complemento, String cidade, String cep) {
		this.rua = rua; 
		this.bairro = bairro;
		this.numero = numero;
		this.complemento = complemento;
		this.cidade = cidade;
		this.cep = cep;
	}

	public String toString() {
		return "[Rua " + rua + ", Bairro " + bairro + ", Nr. " + numero + ", complemento " + complemento
				+ "Cidade " + cidade + ", CEP " + cep + "]";  
	}
	
}
