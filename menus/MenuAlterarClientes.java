package menus;

/**
 * Classe responsável pela alteração de dados dos clientes.
 * Recebe como parametro o cpf do cliente a ser alterado
 * 
 * Opção A: permite a alteração do nome
 * Opção B: permite a alteração da CNH
 * Opção C: permite a alteração do endereço
 * Opção D: permite a alteração do telefone
 * Opção E: volta ao menu de clientes
 * 
 * @param CadClientes cadClientes, String cpf
 */
import java.util.Scanner;

import cadastramentos.CadClientes;

public class MenuAlterarClientes {

    private CadClientes cadClientes;
    private String cpf;

    private Scanner e = new Scanner(System.in);

    public MenuAlterarClientes(CadClientes cadClientes, String cpf) {
        this.cpf = cpf;
        this.cadClientes = cadClientes;
        inicializar();
    }

    private void inicializar() {
        int sair = 0;
        do {
            System.out.println("|===========================================|");
            System.out.println("|======== Qual campo deseja alterar? =======|");
            System.out.println("|===========================================|");
            System.out.println("|          A        |         Nome          |");
            System.out.println("|===========================================|");
            System.out.println("|          B        |          CNH          |");
            System.out.println("|===========================================|");
            System.out.println("|          C        |        Endereço       |");
            System.out.println("|===========================================|");
            System.out.println("|          D        |        Telefone       |");
            System.out.println("|===========================================|");
            System.out.println("|          E        |         Voltar        |");
            System.out.println("|===========================================|");
            System.out.println(" ");
            System.out.print("       Escolha uma das opções acima: ");
            String opcao = e.nextLine();

            switch (opcao) {
                case "a":
                case "A":
                    alterarNome(cpf);
                    break;
                case "b":
                case "B":
                    alterarCnh(cpf);
                    break;
                case "c":
                case "C":
                    alterarEndereco(cpf);
                    break;
                case "d":
                case "D":
                    alterarTelefone(cpf);
                    break;

                case "e":
                case "E":
                    sair = 1;
                    break;
                default:
                    System.out.println("Invalido");
            }
        } while (sair == 0);
    }

    private String textInput(String label) {
        System.out.println(label);
        return e.nextLine();
    }

    // métodos de alteração dos atributos do cliente

    private void alterarNome(String cpf) {
        System.out.println(" ");
        System.out.println("Nome atual: " + cadClientes.get(cpf).getNome());
        String novoNome = textInput("Informe o Novo Nome: ");
        cadClientes.get(cpf).setNome(novoNome);
        msgAlteracaoRealizada();
    }

    private void alterarCnh(String cpf) {
        System.out.println(" ");
        System.out.println("CNH atual: " + cadClientes.get(cpf).getCnh());
        String novaCnh = textInput("Informe a Nova CNH: ");
        cadClientes.get(cpf).setCnh(novaCnh);
        msgAlteracaoRealizada();
    }

    private void alterarEndereco(String cpf) {
        System.out.println(" ");
        System.out.println("Endereço atual: " + cadClientes.get(cpf).getEndereco());
        String novoEndereco = textInput("Informe o Novo Endereço: ");
        cadClientes.get(cpf).setEndereco(novoEndereco);
        msgAlteracaoRealizada();
    }

    private void alterarTelefone(String cpf) {
        System.out.println(" ");
        System.out.println("Telefone atual: " + cadClientes.get(cpf).getTelefone());
        String novoTelefone = textInput("Informe o Novo Telefone: ");
        cadClientes.get(cpf).setTelefone(novoTelefone);
        msgAlteracaoRealizada();
    }

    private void msgAlteracaoRealizada() {
        System.out.println();
        System.out.println("|=============================|");
        System.out.println("|     Alteração Realizada     |");
        System.out.println("|=============================|");
        System.out.println();
    }
}
