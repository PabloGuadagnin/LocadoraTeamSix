package Testes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cadastro.CadLocacoes;
import excepitions.DataInvalidaException;

public class DateTestes {
	
	public static void main (String[]args) throws ParseException {

		String dataAlvo = "10/01/1981";
		String dataIncial = "  /  /    ";
		String dataFinal = "06/01/2023";
		

		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Date alvo = sdf.parse(dataAlvo);
		Date inicial = sdf.parse(dataIncial);
		Date finalera = sdf.parse(dataFinal);
		
		Date currentDate = new Date();
		String currentDateToString = sdf.format(currentDate);
		Date dataAtual = sdf.parse(currentDateToString);
		
		
		
		
		if(alvo.compareTo(inicial) >=0 && alvo.compareTo(finalera) <=0) {
			System.out.println("Está entre o periodo");
		} else {
			System.out.println("Está fora");
		}
		
		System.out.println(dataAtual.compareTo(inicial));
		System.out.println();
		System.out.println();
		
		CadLocacoes cadLocacoes = new CadLocacoes();
		
		try {
			System.out.println(cadLocacoes.validarData(dataIncial));
		} catch (DataInvalidaException e) {

			e.printStackTrace();
		}
		System.out.println();
		
		try {
			System.out.println(cadLocacoes.compararData(dataIncial, dataFinal));
		} catch (DataInvalidaException e) {
			e.printStackTrace();
		}
		
	}	
	
	
}