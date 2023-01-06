package excepitions;

public class ListaClienteVaziaException extends Exception{

	public ListaClienteVaziaException() {
		super("Não há clientes cadastrados.");
	}
}
