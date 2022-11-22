package construtores;

public class Locacao {

    private int codigoLocacao;
    private Cliente cliente;
    private Veiculo veiculo;
    private boolean seguro;
    private int dataInicial;
    private int dataFinal;

    public Locacao(int codigoLocacao, Cliente cliente, Veiculo veiculo, boolean seguro, 
            int dataInicial, int dataFinal) {
        this.codigoLocacao = codigoLocacao;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.seguro = seguro;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    //getters
    public int getCodigoLocacao() {return codigoLocacao;}
    public Cliente getCliente() {return cliente;}
    public Veiculo getVeiculo() {return veiculo;}
    public boolean isSeguro() {return seguro;}
    public int getDataInicial() {return dataInicial;}
    public int getDataFinal() {return dataFinal;}
    
    //setters
    public void setCodigoLocacao(int codigoLocacao) {this.codigoLocacao = codigoLocacao;}
    public void setCliente(Cliente cliente) {this.cliente = cliente;}
    public void setVeiculo(Veiculo veiculo) {this.veiculo = veiculo;}
    public void setSeguro(boolean seguro) {this.seguro = seguro;}
    public void setDataInicial(int dataInicial) {this.dataInicial = dataInicial;}
    public void setDataFinal(int dataFinal) {this.dataFinal = dataFinal;}

    public String toString() {
        return "Locacao [codigoLocacao=" + codigoLocacao + ", cliente=" + cliente.getNome() + ", veiculo=" + veiculo.getPlaca() + ", seguro="
                + seguro + ", dataInicial=" + dataInicial + ", dataFinal=" + dataFinal + "]";
    }
}
