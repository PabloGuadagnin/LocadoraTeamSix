package app;

import javax.swing.SwingUtilities;

import gui.Menu;


public class app {

	public static void main(String[]args) {
		
		SwingUtilities.invokeLater(()->{
			Menu janelaInicial = new Menu();
			janelaInicial.setVisible(true);
		});
	}  
	
}
	


