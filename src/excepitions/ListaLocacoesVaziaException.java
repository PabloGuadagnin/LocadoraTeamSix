package excepitions;

public class ListaLocacoesVaziaException extends Exception{
	public ListaLocacoesVaziaException() {
		super("Não há locações cadastradas.");
	}

}
