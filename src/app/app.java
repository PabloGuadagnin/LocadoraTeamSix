package app;

import javax.swing.SwingUtilities;
import gui.Menu;

/**
 * Classe Main. Executa o programa.
 * @author Team Six
 *
 */
public class app {

	public static void main(String[]args) {
		
		SwingUtilities.invokeLater(()->{
			Menu janelaInicial = new Menu();
			janelaInicial.setVisible(true);
		});
	}  
}
	


