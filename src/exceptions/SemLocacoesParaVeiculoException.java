package exceptions;

public class SemLocacoesParaVeiculoException extends Exception {
	public SemLocacoesParaVeiculoException() {
		super("Não há locações cadastradas para o veículo informado.");
	}
}
