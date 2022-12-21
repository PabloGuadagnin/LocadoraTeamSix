package construtores;

public class Carro extends Veiculo {
    private int numeroPassageiros;
    private int numeroPortas;
    private int kmPlt;
    private boolean arCond;

    public Carro(int numeroPassageiros, int numeroPortas, int kmPlt, boolean arCond,
            String placa, int ano, int valorDiaria) {
        super(placa, ano, valorDiaria);
        this.numeroPassageiros = numeroPassageiros;
        this.numeroPortas = numeroPortas;
        this.kmPlt = kmPlt;
        this.arCond = arCond;
    }

    /**
     * @return Retorna o número de passageiros do veículo
     */
    public int getNumeroPassageiros() {
        return numeroPassageiros;
    }

    /**
     * @param numeroPassageiros Seta o número de passageiros do veículo
     */
    public void setNumeroPassageiros(int numeroPassageiros) {
        try {
            this.numeroPassageiros = numeroPassageiros;
        } catch (Exception e) {
            System.out.println("Ocorreu o erro " + e + " entre com um número válido.");
        }
    }

    /**
     * @return Retorna o número de portas do veículo
     */
    public int getNumeroPortas() {
        return numeroPortas;
    }

    /**
     * @param numeroPortas Seta o número de portas do veículo
     */
    public void setNumeroPortas(int numeroPortas) {
        try {
            this.numeroPortas = numeroPortas;
        } catch (Exception e) {
            System.out.println("Ocorreu o erro " + e + " entre com um número válido.");
        }
    }

    /**
     * @return Retorna a média de km por litro do veículo
     */
    public double getKmPlt() {
        return kmPlt;
    }

    /**
     * @param kmPlt Seta a média de km por litro do veículo
     */
    public void setKmPlt(int kmPlt) {
        try {
            this.kmPlt = kmPlt;
        } catch (Exception e) {
            System.out.println("Ocorreu o erro " + e + " entre com um valor válido.");
        }
    }

    /**
     * @return Retorna se o veículo tem ar condicionado
     */
    public boolean getArCond() {
        return arCond;
    }

    /**
     * @param arCond Seta se o veículo tem ar condicionado
     */
    public void setArCond(boolean arCond) {
        this.arCond = arCond;
    }

    @Override
    public String toString() {
        return "Carro: " + super.toString()
                + ", Número de Passageiros: " + numeroPassageiros
                + ", Número de Portas: " + numeroPortas
                + ", Quilômetros por Litro: " + kmPlt
                + ", Ar Condicionado: " + arCond;
    }
}