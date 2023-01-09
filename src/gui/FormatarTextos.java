package gui;

import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 * Classe de formatação dos campos de texto do tipo JFormattedTextField.
 */
public class FormatarTextos{
	
	public FormatarTextos() {
		
	}

	/** 
	 * Aplica o formato ###.###.###-## para o campo de texto CPF.
	 * O campo aceita apenas numeros.
	 * @param text campo de texto a ser formatado.
	 */
	public void formatarTextCpf(JFormattedTextField text) {
		try {
			MaskFormatter mask = new MaskFormatter("###.###.###-##");
			mask.install(text);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar texto", "ERRO", JOptionPane.ERROR);
		}
	} 

	/** 
	 *  Aplica o formato ########## para o campo de texto cnh.
	 * O campo aceita apenas numeros.
	 * @param text campo de texto a ser formatado.
	 */
	public void formatarTextCnh(JFormattedTextField text) {
		try {
			MaskFormatter mask = new MaskFormatter("###########");
			mask.install(text);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar texto", "ERRO", JOptionPane.ERROR);
		}
	}

	/** 
	 * Aplica o formado (##)####-#### para o campo de texto telefone.
	 * O campo aceita apenas numeros.
	 * @param text campo de texto a ser formatado.
	 */
	public void formatarTextTelefone(JFormattedTextField text) {
		try {
			MaskFormatter mask = new MaskFormatter("(##)####-####");
			mask.install(text);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar texto", "ERRO", JOptionPane.ERROR);
		}
	}
	
	/** 
	 * Aplica o formato #####-### para o campo de texto cep.
	 * O campo aceita apenas números.
	 * @param text campo de texto a ser formatado.
	 */
	public void formatarTextCep(JFormattedTextField text) {
		try {
			MaskFormatter mask = new MaskFormatter("#####-###");
			mask.install(text);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar texto", "ERRO", JOptionPane.ERROR);
		}
	}
	
	/** 
	 * Aplica o formato UUU-#### para o campo de texto placa.
	 * Aceita apenas letras nos espaços com 'U' e apenas numeors nos espaços com '#'.
	 * @param text campo de texto a ser formatado.
	 */
	public void formatarPlaca(JFormattedTextField text) {
		try {
			MaskFormatter mask = new MaskFormatter("UUU-####");
			mask.install(text);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar texto", "ERRO", JOptionPane.ERROR);
		}
	}
	
	/** 
	 * Aplica o formato #### para o campo de texto ano.
	 * Aceita apenas números.
	 * @param text campo de texto a ser formatado.
	 */
	public void formatarTextAno(JFormattedTextField text) {
		try {
			MaskFormatter mask = new MaskFormatter("####");
			mask.install(text);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar texto", "ERRO", JOptionPane.ERROR);
		}
	}
	
	/** 
	 * Aplica o formato ##/##/#### para o campo de texto data.
	 * Aceita apenas números.
	 * @param text campo de texto a ser formatado.
	 */
	public void formatarData(JFormattedTextField text) {
		try {
			MaskFormatter mask = new MaskFormatter("##/##/####");
			mask.install(text);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar texto", "ERRO", JOptionPane.ERROR);
		}
	}	
}
