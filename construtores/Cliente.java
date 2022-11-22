package construtores;
/**
 * Classe responsável pela instanciação e manupulação dos atributops dos clientes.
 */
public class Cliente {

    private String nome;
    private String cpf;
    private String cnh;
    private String endereco;
    private String telefone;

    public Cliente(String nome, String cpf, String cnh, String endereco, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.cnh = cnh;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    //getters
    public String getNome() {return nome;}
    public String getCpf() {return cpf;}
    public String getCnh() {return cnh;}
    public String getEndereco() {return endereco;}
    public String getTelefone() {return telefone;}
    
    //setters
    public void setNome(String nome) {this.nome = nome;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public void setCnh(String cnh) {this.cnh = cnh;}
    public void setEndereco(String endereco) {this.endereco = endereco;}
    public void setTelefone(String telefone) {this.telefone = telefone;}

    public String toString() {
        return "Cliente [Nome: " + nome + ", CPF: " + cpf + ", CNH: " + cnh + ", Endereço: " + endereco + ", Telefone: "
                + telefone + "]";
    }
}
