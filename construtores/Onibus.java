package construtores;
public class Onibus extends Veiculo{
    private int numeroPassageiros;
    private String categoria;
    private boolean wifi;
    private boolean arCond;
    
    public Onibus(int numeroPassageiros, String categoria, boolean wifi, boolean arCond, 
            String placa, int ano, int valorDiaria) {
        super(placa, ano, valorDiaria);
        this.numeroPassageiros = numeroPassageiros;
        this.categoria = categoria;
        this.wifi = wifi;
        this.arCond = arCond;
    }

    //getters
    public int getNumeroPassageiros() {return numeroPassageiros;}
    public String getCategoria() {return categoria;}
    public boolean getWifi() {return wifi;}
    public boolean getArCond() {return arCond;}
    
    //setters
    public void setNumeroPassageiros(int numeroPassageiros) {
    	this.numeroPassageiros = numeroPassageiros;
    }
    public void setCategoria(String categoria) { this.categoria = categoria;}
    public void setWifi(boolean wifi) {this.wifi = wifi;}
    public void setArCond(boolean arCond) {this.arCond = arCond;}

    public String toString() {
        return "Ônibus: " + super.toString() 
            + ", Número de Passageiros: " + numeroPassageiros 
              + ", Categoria: " + categoria 
                + ", WiFi: " + wifi
                  + ", Ar Condicionado: " + arCond ;
    }
}
