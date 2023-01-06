package construtores;

public class Onibus extends Veiculo{
	private String numeroPassageiros;
	private String categoria;
	private boolean internet;
	private boolean arCondicionado;
	
	public Onibus(String placa, String ano, String valorDiaria, String numeroPassageiros, String categoria, boolean internet, boolean arCondicionado) {
		super(placa, ano, valorDiaria);
		this.numeroPassageiros = numeroPassageiros;
		this.categoria = categoria;
		this.internet = internet;
		this.arCondicionado = arCondicionado;
	}

	//geters
	public String getNumeroPassageiros() {return numeroPassageiros;}
	public String getCategoria() {return categoria;}
	public boolean isInternet() {return internet;}
	public boolean isArCondicionado() {return arCondicionado;}
	
	//seters	
	public void setArCondicionado(boolean arCondicionado) {this.arCondicionado = arCondicionado;}
	public void setNumeroPassageiros(String numeroPassageiros) {this.numeroPassageiros = numeroPassageiros;}
	public void setCategoria(String categoria) {this.categoria = categoria;}
	public void setInternet(boolean internet) {	this.internet = internet;}

	public String toString() {
		return "Ônibus ["+ " Placa: " + placa + ", Ano: " + ano + ", Valor da Diária: " + valorDiaria + " Nr. de Passageiros:  " + numeroPassageiros + ", Categoria: " + categoria + ", Internet: " + internet
				+ ", Ar Condicionado: " + arCondicionado + " ]";
	}
}
