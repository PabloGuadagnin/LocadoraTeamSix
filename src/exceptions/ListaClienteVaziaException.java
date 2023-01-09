package exceptions;

public class ListaClienteVaziaException extends Exception{

	public ListaClienteVaziaException() {
		super("Não há clientes cadastrados.");
	}
}
