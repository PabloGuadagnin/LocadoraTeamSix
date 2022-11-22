package menus;

/**
 * Menu para cadastro, verificação e edição de dados referentes aos clientes.
 * 
 * Opção A: instancia e adciona um novo cliente a lista de clientes da classe CadCliente
 * Opção B: busca um cliente na lista pelo CPF e retorna os dados cadastrados (toString)
 * Opção C: imprime uma lista com o CPF e NOme dos  clientes cadastrados
 * Opção D: imprime uma lista com todos os dados dos clientes cadastrados
 * Opção E: chama um novo menu quye permite a alteração dos dados cadastrados de um cliente
 * Opção F: busca pelo CPF e remopve o cliente da lista;
 * Opção G: volta ao menu principal
 * 
 * @param CadClientes
 */

import java.util.Scanner;

import cadastramentos.*;
import construtores.*;

public class MenuClientes {

    private Scanner e = new Scanner(System.in);
    private CadClientes listaClientes;

    public MenuClientes(CadClientes listaClientes) {
        this.listaClientes = listaClientes;
        escolhaClientes();
    }

    private void escolhaClientes() {
        String opcao;
        int sair = 0;
        do {
            System.out.println("|===========================================|");
            System.out.println("|============= MENU DE CLIENTES ============|");
            System.out.println("|============ Locadora Team Six ============|");
            System.out.println("|===========================================|");
            System.out.println("|===========================================|");
            System.out.println("|============ O que Deseja Fazer ? =========|");
            System.out.println("|===========================================|");
            System.out.println("|          A        |   Cadastrar Cliente   |");
            System.out.println("|===========================================|");
            System.out.println("|          B        | Verificar Informações |");
            System.out.println("|===========================================|");
            System.out.println("|          C        |    Listar Clientes    |");
            System.out.println("|===========================================|");
            System.out.println("|          D        | Relatório de Clientes |");
            System.out.println("|===========================================|");
            System.out.println("|          E        |     Alterar Dados     |");
            System.out.println("|===========================================|");
            System.out.println("|          F        |    Remover Cliente    |");
            System.out.println("|===========================================|");
            System.out.println("|          G        |    Voltar ao Menu     |");
            System.out.println("|===========================================|");
            System.out.println(" ");
            System.out.print("       Escolha uma das opções acima: ");
            opcao = e.nextLine();

            switch (opcao) {
                case "a":
                case "A":
                    addCliente();
                    break;
                case "b":
                case "B":
                    System.out.print("");
                    consultaCliente();
                    break;
                case "c":
                case "C":
                    listarCLientes();
                    break;
                case "d":
                case "D":
                    relatorioCLientes();
                    break;
                case "e":
                case "E":
                    menuAlterar();
                    break;
                case "f":
                case "F":
                    excluirCliente();
                    break;
                case "g":
                case "G":
                    sair = 1;
                    break;
                default:
                    System.out.println("	 	\u001B[31m Inválido \u001B[37m");
            }
        } while (sair == 0);
    }

    /**
     * Menu de cadastramento de um novo cliente.
     * Instancia um novo cliente e o adciona a lista de clientes da classe
     * CadClientes.
     */
    private void addCliente() {

        boolean cadastrando = true;

        do {
            Cliente cliente = new Cliente(null, null, null, null, null);

            System.out.println("|===========================================|");
            System.out.println("|=========== CADASTRO DE CLIENTES ==========|");
            System.out.println("|============ Locadora Team Six ============|");
            System.out.println("|===========================================|");
            System.out.println(" ");
            cliente.setNome(textInput("Informe o Nome do Cliente: "));
            System.out.println(" ");
            cliente.setCpf(textInput("Informe o CPF do Cliente: "));
            System.out.println(" ");
            cliente.setCnh(textInput("Informe a CNH do Cliente: "));
            System.out.println(" ");
            cliente.setEndereco(textInput("Informe o Endereço do Cliente: "));
            System.out.println(" ");
            cliente.setTelefone(textInput("Informe o Telefone do Cliente: "));
            System.out.println(" ");

            String confirmar = textInput("Deseja Confirmar o Cadastro (S/N) ?");
            switch (confirmar) {
                case "n":
                case "N":
                    break;
                case "s":
                case "S":
                    listaClientes.add(cliente);
                    System.out.println("\u001B[32m Cadastro Efetuado com Sucesso! \u001B[37m");
                    break;
                default:
                    System.out.println("\u001B[31m Inválido \u001B[37m");
            }

            String continua = textInput("Cadastrar outro Cliente (S/N) ?");
            switch (continua) {
                case "n":
                case "N":
                    cadastrando = false;
                    break;
                case "s":
                case "S":
                    break;
                default:
                    System.out.println("\u001B[31m Inválido \u001B[37m");
                    cadastrando = false;
            }
        } while (cadastrando);
    }

    private void consultaCliente() {
        System.out.println("Informe o CPF do cliente a ser consultado: ");
        String cpf = e.nextLine();
        if (listaClientes.existe(cpf)) {
            System.out.println(listaClientes.getInfo(cpf));
            escolhaClientes();
        } else {
            msgClienteInexistente();
        }
    }

    private void listarCLientes() {
        if (listaClientes.getListaCLientes().isEmpty()) {
            msgListaVazia();
        } else {
            System.out.println();
            System.out.println(listaClientes.getResumoInfo());
            System.out.println();
        }
    }

    private void relatorioCLientes() {
        if (listaClientes.getListaCLientes().isEmpty()) {
            msgListaVazia();
        } else {
            System.out.println();
            System.out.println(listaClientes.getInfo());
            System.out.println();
        }
    }

    private void excluirCliente() {
        System.out.println("Informe o CPF do cliente que deseja remover: ");
        String cpf = e.nextLine();
        if (listaClientes.existe(cpf)) {
            listaClientes.remove(cpf);
            msgClienteRemovido();
        } else {
            msgClienteInexistente();
        }
    }

    private String textInput(String label) {
        System.out.println(label);
        return e.nextLine();
    }

    private void msgListaVazia() {
        System.out.println();
        System.out.println("|=============================|");
        System.out.println("| Não há clientes cadastrados |");
        System.out.println("|=============================|");
        System.out.println();
    }

    private void msgClienteInexistente() {
        System.out.println();
        System.out.println("|=============================|");
        System.out.println("|     Cliente inexistente     |");
        System.out.println("|=============================|");
        System.out.println();
    }

    private void msgClienteRemovido() {
        System.out.println();
        System.out.println("|=============================|");
        System.out.println("|       Cliente Removido      |");
        System.out.println("|=============================|");
        System.out.println();
    }

    /**
     * Método chama o menu com as opções de alteraçõpes de dados do cliente
     * selecionado.
     */
    private void menuAlterar() {
        System.out.println("Informe o CPF do cliente que deseja alterar: ");
        String cpf = e.nextLine();
        if (listaClientes.existe(cpf)) {
            MenuAlterarClientes menuAlterarClientes = new MenuAlterarClientes(listaClientes, cpf);
        } else {
            msgClienteInexistente();
        }
    }
}
