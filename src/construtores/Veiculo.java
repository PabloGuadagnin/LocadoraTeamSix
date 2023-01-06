package construtores;

public class Veiculo{

	protected String placa;
	protected String ano;
	protected String valorDiaria;

	
	public Veiculo (String placa, String ano, String valorDiaria) {
		this.placa = placa;
		this.ano = ano;
		this.valorDiaria = valorDiaria;
	}
	
	//geters	
    public String getPlaca() {return placa;}
	public String getAno() {return ano;}
	public String getValorDiaria() {return valorDiaria;}

	//seters
	public void setPlaca(String placa) {this.placa = placa;}
	public void setAno(String ano) {this.ano = ano;}
	public void setValorDiaria(String valorDiaria) {this.valorDiaria = valorDiaria;}

	public String resumoInfo() { 
		return "Placa: " + placa  + ", Ano: " + ano + ", Valor diária: " + valorDiaria + "\n";
	}
	
	

}
