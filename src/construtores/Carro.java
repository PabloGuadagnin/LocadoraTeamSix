package construtores;

public class Carro extends Veiculo {
	
	private String numPassageiros;
    private int numPortas;
    private String kmPorLitro;
    private boolean arCondicionado;
    
    public Carro(String placa, String ano, String valorDiaria, String numPassageiros,
    		int numPortas, String kmPorLitro, boolean arCondicionado) {
		super(placa, ano, valorDiaria);
		this.numPassageiros = numPassageiros;
		this.numPortas = numPortas;
		this.kmPorLitro = kmPorLitro;
		this.arCondicionado = arCondicionado;
	}
    
    //geters
    public String getNumPassageiros() {return numPassageiros;}
    public int getNumPortas() {return numPortas;}
    public String getKmPorLitro() {return kmPorLitro;}
    public boolean getArCondicionado() {return arCondicionado;}
    
    //seters
    public void setNumPassageiros(String numPassageiros) {this.numPassageiros = numPassageiros;}
    public void setNumPortas (int numPortas) {this.numPortas = numPortas;}
    public void setKmPorLitro(String kmPorLitro) {this.kmPorLitro = kmPorLitro;}
    public void setArCondicionado(boolean arCondicionado) {this.arCondicionado = arCondicionado;}

	public String toString() {
		return "Carro [" + " Placa: " + placa + ", Ano: " + ano + ", Valor da Diária: " + valorDiaria +
				", Nr. de Passageiros: " + numPassageiros + ", Nr. de Portas: " + numPortas + ", km/l: " 
				+ kmPorLitro + ", Ar Condicionado:" + arCondicionado + " ]";
	}
	
}