package menus;

import java.util.Scanner;

import cadastramentos.*;
import construtores.*;

public class MenuLocacoes {
    int cod = 1;
    Boolean deseja = true;
    static Scanner e = new Scanner(System.in);

    private CadClientes listaClientes;
    private CadVeiculos listaVeiculos;
    private CadLocacoes listaLocacoes;

    public MenuLocacoes(CadLocacoes listaLocacoes, CadVeiculos listaVeiculos, CadClientes listaClientes) {
        this.listaClientes = listaClientes;
        this.listaVeiculos = listaVeiculos;
        this.listaLocacoes = listaLocacoes;
    }

    public void escolhaLocacao() {
        String opcao;
        int sair = 0;
        do {
            System.out.println("|===========================================|"); // Menu do programa
            System.out.println("|============= MENU DE LOCAÇÕES ============|");
            System.out.println("|============ Locadora Team Six ============|"); // Menu do programa
            System.out.println("|===========================================|");
            System.out.println("|===========================================|"); // Menu do programa
            System.out.println("|============ O que Deseja Fazer ? =========|");
            System.out.println("|===========================================|"); // Menu do programa
            System.out.println("|          A        |   Cadastrar Locação   |"); // Menu do programa
            System.out.println("|===========================================|"); // Menu do programa
            System.out.println("|          B        | Verificar Informações |"); // Menu do programa
            System.out.println("|===========================================|"); // Menu do programa
            System.out.println("|          C        |    Excluir locação    |"); // Menu do programa
            System.out.println("|===========================================|"); // Menu do programa
            System.out.println("|          D        |   Lista de locações   |"); // Menu do programa
            System.out.println("|===========================================|"); // Menu do programa
            System.out.println("|          E        | \u001B[31m  Voltar ao Menu 	\u001B[37m    |"); // Menu do
                                                                                                       // programa
            System.out.println("|===========================================|"); // Menu do programa
            System.out.println(" ");
            System.out.print("       Escolha uma das opções acima: ");
            opcao = e.nextLine();
            switch (opcao) {
                case "a":
                case "A":
                    addLocacao();
                    break;
                case "b":
                case "B":
                    listaaLocacao();
                    break;
                case "c":
                case "C":
                    excluirLocacao();
                    break;
                case "d":
                case "D":
                    relatorioLocacao();
                    break;
                case "e":
                case "E":
                    sair = 1;
                    break;
                default:
                    System.out.println("\u001B[31m Invalido \u001B[37m");
            }
        } while (sair == 0);
    }

    private void addLocacao() {

        boolean cadastrando = true;
        while (cadastrando) {

            Locacao locacao = new Locacao(cod, null, null, deseja, 0, 0);

            System.out.println("|===========================================|"); // Menu do programa
            System.out.println("|=========== CADASTRO DE LOCAÇÕES ==========|"); // Menu do programa
            System.out.println("|============ Locadora Team Six ============|"); // Menu do programa
            System.out.println("|===========================================|");
            System.out.println(" ");
            System.out.println("Informe o CPF do Cliente: ");
            String cpf = e.nextLine();
            locacao.setCliente(listaClientes.get(cpf));
            System.out.println(" ");
            System.out.println("Informe a Placa do Veículo: ");
            String placa = e.nextLine();
            locacao.setVeiculo(listaVeiculos.get(placa));
            System.out.println(" ");
            // Boolean para o seguro
            String seguro = textInput("Informe se Deseja Seguro: (S/N) ");
            switch (seguro) {
                case "n":
                case "N":
                    deseja = false;
                    break;
                case "s":
                case "S":
                    deseja = true;
                    break;
                default:
                    System.out.println(" Invalido, seguro não habilitado.");
                    deseja = false;
                    break;
            }

            System.out.println(" ");
            System.out.println("Informe a data Inicial, não use /, escreva DDMMAAAA: ");
            locacao.setDataInicial(e.nextInt());
            System.out.println(" ");
            System.out.println("Informe a Data Final, não use /, escreva DDMMAAAA: ");
            locacao.setDataFinal(e.nextInt());
            System.out.println(" ");

            e.nextLine();

            String confirmar = textInput("Deseja Confirmar o Cadastro (S/N) ?");
            if (confirmar.equals("N") || (confirmar.equals("n"))) {
                // Volta para o início do while.
            } else if (confirmar.equals("s") || (confirmar.equals("S"))) {
                listaLocacoes.add(locacao);
                cod++;
                System.out.println("Seu código é: " + (cod - 1));
                e.nextLine();
                System.out.println("Cadastro Efetuado com \u001B[32m Sucesso! \u001B[37m");
            } else {
                System.out.println("\u001B[31m Opção Inválida! \u001B[37m");
                // Volta para o início do While.
            }

            String continua = textInput("Cadastrar outra Locação (S/N) ?");
            if (continua.equals("N") || (continua.equals("n"))) {
                cadastrando = false;
            } else if (continua.equals("s") || (continua.equals("S"))) {
                // se for s sai do if e volta para o inicio do while
            } else {
                System.out.println("\u001B[31m Opção Inválida! \u001B[37m");
                cadastrando = false;
            }
        }
    }

    private void listaaLocacao() {

        System.out.println("Informe o Código da Locação a ser consultada: ");
        int codigo = e.nextInt();
        System.out.println(listaLocacoes.getInfo(codigo));
        e.nextLine();
        escolhaLocacao();

    }

    private String textInput(String label) {
        System.out.println(label);
        return e.nextLine();
    }

    /**
     * Método para excluir uma locação usando o código de locação
     * 
     * @param locacao o locação a ser removida da lista de locações
     */
    private void excluirLocacao() {

        System.out.println("Informe o código da locação a ser \u001B[31m excluida \u001B[37m : ");
        int codigo = e.nextInt();
        e.nextLine();
        String confirmar = textInput("Essa Ação \u001B[31m NÃO \u001B[37m Pode Ser Desfeita, Tem Certeza? (S/N) ");
        if (confirmar.equals("N") || (confirmar.equals("n"))) {
            System.out.println("Locação \u001B[31m NÃO \u001B[37m Excluida!");
        } else if (confirmar.equals("s") || (confirmar.equals("S"))) {
            listaLocacoes.remove(codigo);
            System.out.println("Locação Excluida com \u001B[32m Sucesso! \u001B[37m");
        } else {
            System.out.println("\u001B[31m Opção Inválida, Locaçao NÃO Excluida! \u001B[37m");
        }
    }

    private void relatorioLocacao() {
        if (listaLocacoes.getListaLocacoes().isEmpty()) {
            msgListaVazia();
        } else {
            System.out.println();
            System.out.println(listaLocacoes.getInfo());
            System.out.println();
        }
    }

    private void msgListaVazia() {
        System.out.println();
        System.out.println("|=============================|");
        System.out.println("| \u001B[31mNão\u001B[37m há locações cadastradas |");
        System.out.println("|=============================|");
        System.out.println();
    }
}