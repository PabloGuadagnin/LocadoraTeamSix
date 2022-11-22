package construtores;

public class Veiculo{

    private String placa;
    private int ano, valorDiaria;    

    public Veiculo(String placa, int ano, int valorDiaria) {
        this.placa = placa;
        this.ano = ano;
        this.valorDiaria = valorDiaria;
    }

    //getters
    public String getPlaca() {return placa;}
    public int getAno() {return ano;}
    public int getValorDiaria() {return valorDiaria;}
    
    //setters
    public void setPlaca(String placa) {this.placa = placa;}
    public void setAno(int ano) {this.ano = ano;}
    public void setValorDiaria(int valorDiaria) {this.valorDiaria = valorDiaria;}

    public String toString() {
        return " Placa: " + placa + ", Ano: " + ano + ", Valor da Diária: " + valorDiaria;
    }

}
