package construtores;

public class Veiculo {

    private String placa;
    private int ano, valorDiaria;

    public Veiculo(String placa, int ano, int valorDiaria) {
        this.placa = placa;
        this.ano = ano;
        this.valorDiaria = valorDiaria;
    }

    // getters
    public String getPlaca() {
        return placa;
    }

    public int getAno() {
        return ano;
    }

    public int getValorDiaria() {
        return valorDiaria;
    }

    // setters
    public void setPlaca(String placa) {
        try {
            this.placa = placa;
        } catch (Exception e) {
            System.out.println("Ocorreu o erro " + e + " entre com uma placa válida.");
        }
    }

    public void setAno(int ano) {
        try {
            this.ano = ano;
        } catch (Exception e) {
            System.out.println("Ocorreu o erro " + e + " entre com um ano válido.");
        }
    }

    public void setValorDiaria(int valorDiaria) {
        try {
            this.valorDiaria = valorDiaria;
        } catch (Exception e) {
            System.out.println("Ocorreu o erro " + e + " entre com um valor válido.");
        }
    }

    public String toString() {
        return " Placa: " + placa
                + ", Ano: " + ano
                + ", Valor da Diária: "
                + valorDiaria;
    }

}
