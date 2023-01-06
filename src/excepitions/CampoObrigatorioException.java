package excepitions;

public class CampoObrigatorioException extends Exception {

	public CampoObrigatorioException () {
		super("Campos NOME e CNH obrigatórios.");
	}
}
