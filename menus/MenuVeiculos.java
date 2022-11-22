package menus;

import java.util.Scanner;

import cadastramentos.*;
import construtores.*;

public class MenuVeiculos {

    static Scanner e = new Scanner(System.in);

    private CadVeiculos listaVeiculos;

    public MenuVeiculos(CadVeiculos listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public void escolhaVeiculos() {
        String opcao;
        int sair = 0;
        do {
            System.out.println("|===========================================|"); // Menu do programa
            System.out.println("|============= MENU DE VEÍCULOS ============|"); // Menu do programa
            System.out.println("|============ Locadora Team Six ============|"); // Menu do programa
            System.out.println("|===========================================|");
            System.out.println("|===========================================|"); // Menu do programa
            System.out.println("|============ O que Deseja Fazer ? =========|");
            System.out.println("|===========================================|"); // Menu do programa
            System.out.println("|          A        |   Cadastrar Veículo   |"); // Menu do programa
            System.out.println("|===========================================|"); // Menu do programa
            System.out.println("|          B        | Verificar Informações |"); // Menu do programa
            System.out.println("|===========================================|"); // Menu do programa
            System.out.println("|          C        |    Excluir Veículo    |"); // Menu do programa
            System.out.println("|===========================================|"); // Menu do programa
            System.out.println("|          D        |  \u001B[31m  Voltar ao Menu   \u001B[37m  |"); // Menu do programa
            System.out.println("|===========================================|"); // Menu do programa
            System.out.println(" ");
            System.out.print("       Escolha uma das opções acima: ");
            opcao = e.nextLine();
            switch (opcao) {
                case "a":
                case "A":
                    addVeiculo();
                    break;
                case "b":
                case "B":
                    consultaVeiculo();
                    break;
                case "c":
                case "C":
                    excluiVeiculo();
                    break;
                case "d":
                case "D":
                    sair = 1;
                    break;
                default:
                    System.out.println("\u001B[31m Opção Inválida \u001B[37m");
            }
        } while (sair == 0);
    }

    public void addVeiculo() {

        boolean cadastrando = true;
        while (cadastrando) {

            Veiculo veiculo;

            System.out.println("|===========================================|"); // Menu do programa
            System.out.println("|=========== CADASTRO DE VEICULOS ==========|"); // Menu do programa
            System.out.println("|============ Locadora Team Six ============|"); // Menu do programa
            System.out.println("|===========================================|");
            System.out.println(" ");
            System.out.println("Informe a Placa do Veículo: ");
            String placa = e.nextLine();
            System.out.println(" ");
            System.out.println("Informe o Ano do Veículo: ");
            int ano = e.nextInt();
            System.out.println(" ");
            System.out.println("Informe o Valor da Diária: ");
            int valorDiaria = e.nextInt();
            System.out.println(" ");
            e.nextLine();
            System.out.println("Informe o Tipo do Veículo: ");
            System.out.println("A - Caminhão");
            System.out.println("B - Carro");
            System.out.println("C - Ônibus");
            String tipoVeiculo = e.nextLine();
            System.out.println(" ");

            switch (tipoVeiculo) {
                case "a":
                case "A": // Caminhão
                    System.out.println("Informe o Número de Eixos: ");
                    int numeroEixos = e.nextInt();
                    System.out.println(" ");
                    System.out.println("Informe a Carga Máxima: ");
                    int cargaMax = e.nextInt();
                    System.out.println(" ");
                    e.nextLine();

                    veiculo = new Caminhao(numeroEixos, cargaMax, placa, ano, valorDiaria);

                    String confirmar = textInput("Deseja Confirmar o Cadastro (S/N) ?");
                    if (confirmar.equals("N") || (confirmar.equals("n"))) {
                        // Volta para o início do while.
                    } else if (confirmar.equals("s") || (confirmar.equals("S"))) {
                        listaVeiculos.add(veiculo);
                        System.out.println("Cadastro Efetuado com Sucesso!");
                    } else {
                        System.out.println("Opção Inválida!");
                        // Volta para o início do While.
                    }
                    break;

                case "b":
                case "B": // Carro

                    System.out.println("Informe o Número de Passageiros: ");
                    int numeroPassageiros = e.nextInt();
                    System.out.println(" ");
                    System.out.println("Informe o Número de Portas: ");
                    int numeroPortas = e.nextInt();
                    System.out.println(" ");
                    System.out.println("Informe o Número de Kilometros por Litro: ");
                    Double kmPLt = e.nextDouble();
                    System.out.println(" ");
                    e.nextLine();

                    Boolean arCond = true;
                    String possui = textInput("Informe se Possui Ar Condicionado: (S/N) ");
                    if (possui.equals("N") || (possui.equals("n"))) {
                        arCond = false;
                    } else if (possui.equals("s") || (possui.equals("S"))) {
                        arCond = true;
                    } else {
                        System.out.println("Opção Inválida, Possui Ar Condicionado por Padrão");
                        arCond = true;
                    }

                    veiculo = new Carro(numeroPassageiros, numeroPortas, kmPLt, arCond, placa, ano, valorDiaria);

                    confirmar = textInput("Deseja Confirmar o Cadastro (S/N) ?");
                    if (confirmar.equals("N") || (confirmar.equals("n"))) {
                        // Volta para o início do while.
                    } else if (confirmar.equals("s") || (confirmar.equals("S"))) {
                        listaVeiculos.add(veiculo);
                        System.out.println("Cadastro Efetuado com Sucesso!");
                        System.out.print("\033[H\033[2J"); // comando para limpar terminal.
                    } else {
                        System.out.println("Opção Inválida!");
                        // Volta para o início do While.
                    }
                    break;

                case "c":
                case "C": // Ônibus

                    System.out.println("Informe o Número de Passageiros: ");
                    int numeroPassageirosOn = e.nextInt();
                    e.nextLine();
                    System.out.println(" ");
                    System.out.println("Informe a Categoria do Ônibus: ");
                    String categoria = e.nextLine();
                    System.out.println(" ");

                    Boolean wifi = true;
                    possui = textInput("Informe se Possui Wifi: (S/N) ");
                    if (possui.equals("N") || (possui.equals("n"))) {
                        wifi = false;
                    } else if (possui.equals("s") || (possui.equals("S"))) {
                        wifi = true;
                    } else {
                        System.out.println("Opção Inválida, Possui Wifi por Padrão");
                        wifi = true;
                    }
                    System.out.println(" ");

                    arCond = true;
                    possui = textInput("Informe se Possui Ar Condicionado: (S/N) ");
                    if (possui.equals("N") || (possui.equals("n"))) {
                        arCond = false;
                    } else if (possui.equals("s") || (possui.equals("S"))) {
                        arCond = true;
                    } else {
                        System.out.println("Opção Inválida, Possui Ar Condicionado por Padrão");
                        arCond = true;
                    }
                    System.out.println(" ");

                    veiculo = new Onibus(numeroPassageirosOn, categoria, wifi, arCond, placa, ano, valorDiaria);

                    confirmar = textInput("Deseja Confirmar o Cadastro (S/N) ?");
                    if (confirmar.equals("N") || (confirmar.equals("n"))) {
                        // Volta para o início do while.
                    } else if (confirmar.equals("s") || (confirmar.equals("S"))) {
                        listaVeiculos.add(veiculo);
                        System.out.println("Cadastro Efetuado com Sucesso!");
                    } else {
                        System.out.println("Opção Inválida!");
                        // Volta para o início do While.
                    }
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }

            String continua = textInput("Cadastrar outro Veículo (S/N) ?");
            if (continua.equals("N") || (continua.equals("n"))) {
                cadastrando = false;
            } else if (continua.equals("s") || (continua.equals("S"))) {
                // se for s sai do if e volta para o inicio do while
            } else {
                System.out.println("Opção Inválida!");
                cadastrando = false;
            }
        }
    }

    private void consultaVeiculo() {
        System.out.println("Informe a Placa do Veículo a ser Consultado ou um ENTER para Todos: ");
        String placa = e.nextLine();
        if (placa == "") {
            listarVeiculos();
        } else
            System.out.println(listaVeiculos.getInfo(placa));
    }

    private void listarVeiculos() {
        System.out.println();
        System.out.println(listaVeiculos.getInfo());
        System.out.println();
    }

    private void excluiVeiculo() {
        System.out.println("Informe a Placa do Veículo a ser Excluido: ");
        String placa = e.nextLine();

        String confirmar = textInput("Essa Ação NÂO Pode Ser Desfeita, Tem Certeza? (S/N) ");
        if (confirmar.equals("N") || (confirmar.equals("n"))) {
            System.out.println("Veículo NÃO Foi Excluido!");
        } else if (confirmar.equals("s") || (confirmar.equals("S"))) {
            listaVeiculos.remove(placa);
            System.out.println("Veículo Foi Excluido com Sucesso!");
        } else {
            System.out.println("Opção Inválida, Veículo NÃO Foi Excluido!");

        }
    }

    private String textInput(String label) {
        System.out.println(label);
        return e.nextLine();
    }
}// 9