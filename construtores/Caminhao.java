package construtores;
public class Caminhao extends Veiculo{
    private int numeroEixos;
    private int cargaMax;

    public Caminhao(int numeroEixos, int cargaMax, String placa,
             int ano, int valorDiaria) {
        super(placa, ano, valorDiaria);
        this.numeroEixos = numeroEixos;
        this.cargaMax = cargaMax;
    }

    //getters
    public int getNumeroEixos() {return numeroEixos;}
    public int getCargaMax() {return cargaMax;}

    //setters
    public void setNumeroEixos(int numeroEixos) {
        this.numeroEixos = numeroEixos;
    }
    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    
    public String toString() {
        return "Caminhão: " + super.toString() 
            + ", Número de Eixos: " + numeroEixos 
              + ", Carga Máxima: " + cargaMax;
    }
}
