package excepitions;



public class SemLocacoesParaClienteException extends Exception {
	public SemLocacoesParaClienteException() {
		super("Não a locações para o cliente informado.");
	}
}
