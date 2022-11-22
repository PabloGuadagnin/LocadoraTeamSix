package menus;

import java.util.Scanner;

import cadastramentos.*;

	/*Cores
  PRETO	    \u001B[30m	
  VERMELHO	\u001B[31m	
  VERDE	    \u001B[32m	
  AMARELO	    \u001B[33m	
  AZUL	    \u001B[34m	
  ROXA	    \u001B[35m	
  CIANO	    \u001B[36m	
  BRANCO	    \u001B[37m	
   */

public class MenuPrincipal {
	
    CadClientes listaClientes = new CadClientes();
    CadVeiculos listaVeiculos = new CadVeiculos();
    CadLocacoes listaLocacoes = new CadLocacoes();

    private MenuClientes menuClientes;
    private MenuVeiculos menuVeiculos;
    private MenuLocacoes menuLocacoes;

    public MenuPrincipal() {
        menuClientes = new MenuClientes(listaClientes);
        menuVeiculos = new MenuVeiculos(listaVeiculos);
        menuLocacoes = new MenuLocacoes(listaLocacoes, listaVeiculos, listaClientes);
        start();
    }

    /**
     * Inicia o menu do programa dando opções ao usuário
     */
    private void start() {
        Scanner teclado = new Scanner(System.in);
        int sair = 0;
        String opcao;
        do {
            System.out.println("|===========================================|"); // Menu do programa
            System.out.println("|============= Seja bem-vindo! =============|"); // Menu do programa
            System.out.println("|============ Locadora Team Six ============|"); // Menu do programa
            System.out.println("|===========================================|"); // Menu do programa
            System.out.println("|======= Selecione o que deseja fazer ======|"); // Menu do programa
            System.out.println("|===========================================|"); // Menu do programa
            System.out.println("|          A        |    Menu de Clientes   |"); // Menu do programa
            System.out.println("|===========================================|"); // Menu do programa
            System.out.println("|          B        |    Menu de Veículos   |"); // Menu do programa
            System.out.println("|===========================================|"); // Menu do programa
            System.out.println("|          C        |    Menu de Locações   |"); // Menu do programa
            System.out.println("|===========================================|"); // Menu do programa
            System.out.println("|          D        |     \u001B[31m    SAIR      \u001B[37m    |"); // Menu do programa
            System.out.println("|===========================================|"); // Menu do programa
            System.out.println(" ");
            System.out.print("       Escolha uma das opções acima: ");
            opcao = teclado.nextLine();

            switch (opcao) {
                case "a": case "A":
                    System.out.print("\033[H\033[2J");
                    menuClientes = new MenuClientes(listaClientes);
                    break;
                case "b": case "B":
                    System.out.print("\033[H\033[2J");
                    menuVeiculos.escolhaVeiculos();
                    break;
                case "c": case "C":
                    System.out.print("\033[H\033[2J");
                    menuLocacoes.escolhaLocacao();
                    break;
                case "d": case "D":
                    sair = 1;
                    System.out.println("");
                    System.out.println(" Você Escolheu Sair ! "); // Caso o usuário decida sair
                    System.out.println("");
                    break;
                default:
                    System.out.println("	 	\u001B[31m Invalido \u001B[37m");
            }
        } while (sair == 0);
        teclado.close();
    }
}