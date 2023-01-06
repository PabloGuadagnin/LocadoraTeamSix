package gui;

import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class FormatarTextos{
	
	
	public FormatarTextos() {
		
	}

	public void formatarTextCpf(JFormattedTextField text) {
		try {
			MaskFormatter mask = new MaskFormatter("###.###.###-##");
			mask.install(text);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar texto", "ERRO", JOptionPane.ERROR);
		}
	} 

	public void formatarTextCnh(JFormattedTextField text) {
		try {
			MaskFormatter mask = new MaskFormatter("###########");
			mask.install(text);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar texto", "ERRO", JOptionPane.ERROR);
		}
	}

	public void formatarTextTelefone(JFormattedTextField text) {
		try {
			MaskFormatter mask = new MaskFormatter("(##)####-####");
			mask.install(text);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar texto", "ERRO", JOptionPane.ERROR);
		}
	}
	
	public void formatarTextCep(JFormattedTextField text) {
		try {
			MaskFormatter mask = new MaskFormatter("#####-###");
			mask.install(text);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar texto", "ERRO", JOptionPane.ERROR);
		}
	}
	
	public void formatarPlaca(JFormattedTextField text) {
		try {
			MaskFormatter mask = new MaskFormatter("UUU-####");
			mask.install(text);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar texto", "ERRO", JOptionPane.ERROR);
		}
	}
	
	public void formatarTextAno(JFormattedTextField text) {
		try {
			MaskFormatter mask = new MaskFormatter("####");
			mask.install(text);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar texto", "ERRO", JOptionPane.ERROR);
		}
	}
	
	public void formatarData(JFormattedTextField text) {
		try {
			MaskFormatter mask = new MaskFormatter("##/##/####");
			mask.install(text);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar texto", "ERRO", JOptionPane.ERROR);
		}
	}
	
	public void formatarTextNome(JFormattedTextField text) {
		try {
			MaskFormatter mask = new MaskFormatter("###.###.###-##");
			mask.install(text);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar texto", "ERRO", JOptionPane.ERROR);
		}
	} 
	
}
