package construtores;

/**
 * Classe responsável pela instanciação e manupulação dos atributops dos
 * clientes.
 */
public class Cliente {

    private String nome;
    private long cpf;
    private long cnh;
    private String endereco;
    private long telefone;

    public Cliente(String nome, long cpf, long cnh, String endereco, long telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.cnh = cnh;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    // getters
    public String getNome() {
        return nome;
    }

    public long getCpf() {
        return cpf;
    }

    public long getCnh() {
        return cnh;
    }

    public String getEndereco() {
        return endereco;
    }

    public long getTelefone() {
        return telefone;
    }

    // setters
    public void setNome(String nome) {
        try {
            this.nome = nome;
        } catch (Exception e) {
            System.out.println("Ocorreu o erro " + e + " entre com um nome válido.");
        }
    }

    public void setCpf(long cpf) {
        try {
            this.cpf = cpf;
        } catch (Exception e) {
            System.out.println("Ocorreu o erro " + e + " entre com um CPF válido.");
        }
    }

    public void setCnh(long cnh) {
        try {
            this.cnh = cnh;
        } catch (Exception e) {
            System.out.println("Ocorreu o erro " + e + " entre com uma CNH válida.");
        }
    }

    public void setEndereco(String endereco) {
        try {
            this.endereco = endereco;
        } catch (Exception e) {
            System.out.println("Ocorreu o erro " + e + " entre com um endereço válido.");
        }
    }

    public void setTelefone(long telefone) {
        try {
            this.telefone = telefone;
        } catch (Exception e) {
            System.out.println("Ocorreu o erro " + e + " entre com um telefone válido.");
        }
    }

    public String toString() {
        return "Cliente: " + nome
                + ", CPF: " + cpf
                + ", CNH: " + cnh
                + ", Endereço: " + endereco
                + ", Telefone: " + telefone;
    }
}
