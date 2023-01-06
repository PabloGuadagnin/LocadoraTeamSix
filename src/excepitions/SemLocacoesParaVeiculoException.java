package excepitions;

public class SemLocacoesParaVeiculoException extends Exception {
	public SemLocacoesParaVeiculoException() {
		super("Não há locações cadastradas para o veículo informado.");
	}
}
