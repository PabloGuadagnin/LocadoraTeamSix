package construtores;

public class Caminhao extends Veiculo {
	

	private String numeroEixos;
	private String cargaMaxima;
	
	public Caminhao(String placa, String ano, String valorDiaria, String numeroEixos, String cargaMaxima) {
		super(placa, ano, valorDiaria);
		this.numeroEixos = numeroEixos;
		this.cargaMaxima = cargaMaxima;
	}
	
	//geters
	public String getNumeroEixos() {return numeroEixos;}
	public String getCargaMaxima() {return cargaMaxima;}

	//seters
	public void setNumeroEixos(String numeroEixos) {this.numeroEixos = numeroEixos;}
	public void setCargaMaxima(String cargaMaxima) {this.cargaMaxima = cargaMaxima;}

	public String toString() {
		return "Caminhão [" + " Placa: " + placa + ", Ano: " + ano + ", Valor da Diária: " + valorDiaria + 
				" Nr. de Eixos: " + numeroEixos + ", Carga Máxima (kg): " + cargaMaxima +  " ]";
	}
	
}
