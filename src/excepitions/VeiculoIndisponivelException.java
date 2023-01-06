package excepitions;

public class VeiculoIndisponivelException extends Exception{
	
	public VeiculoIndisponivelException() {
		super("Veículo indisponível nesta data.");
	}

}
