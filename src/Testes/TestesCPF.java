package Testes;

import cadastro.ValidaCPF;
import exceptions.CpfInvalidoException;

/**
 * Classe de testes de verificação dos métodos da classe VerificaCPF.
 */
public class TestesCPF {

	public static void main(String[] args) {

		ValidaCPF validaCPF = new ValidaCPF();
		
		System.out.println(validaCPF.fotmatarCPF("001.436.300-32"));
		
		try {
			System.out.println(validaCPF.isCPF("011.436.300-32"));
		} catch (CpfInvalidoException e) {
		
			e.printStackTrace();
		}
	}
}
