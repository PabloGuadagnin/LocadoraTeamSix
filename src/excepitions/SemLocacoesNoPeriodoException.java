package excepitions;

public class SemLocacoesNoPeriodoException extends Exception {
	public SemLocacoesNoPeriodoException() {
		super("Não há locações cadastradas no período informado.");
	}

}
