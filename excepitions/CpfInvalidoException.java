package excepitions;

public class CpfInvalidoException extends RuntimeException{
	
	CpfInvalidoException (String message){
		super(message);
	}
}
