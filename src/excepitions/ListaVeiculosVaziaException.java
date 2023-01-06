package excepitions;

public class ListaVeiculosVaziaException extends Exception {
	public ListaVeiculosVaziaException() {
		super("Não há veículos cadastrados.");
	}

}
