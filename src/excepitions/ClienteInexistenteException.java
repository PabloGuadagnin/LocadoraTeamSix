package excepitions;

public class ClienteInexistenteException extends Exception {
	public ClienteInexistenteException() {
		super("Cliente inexistente.");
	}
}
