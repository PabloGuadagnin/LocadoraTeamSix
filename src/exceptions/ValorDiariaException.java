package exceptions;

public class ValorDiariaException extends Exception {
	
	public ValorDiariaException() {
		super("Valor da diária inválida. Utilize apenas números e ponto ('.').");
	}
}
