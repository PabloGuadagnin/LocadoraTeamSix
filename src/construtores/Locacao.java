package construtores;

public class Locacao {

	private static int codigoGeral = 1;
	private int codigoLocacao;
	private Cliente cliente;
	private Veiculo veiculo;
	private boolean seguro;
	private String dataIncial, dataFinal;

	
	public Locacao(Cliente cliente, Veiculo veiculo, boolean seguro, String dataIncial, String dataFinal) {
		this.codigoLocacao = codigoGeral++;
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.seguro = seguro;
		this.dataIncial = dataIncial;
		this.dataFinal = dataFinal;
	}

	//geters
    public int getCodigoLocacao() {return codigoLocacao;}
    public Cliente getCliente() {return cliente;}
    public Veiculo getVeiculo() {return veiculo;}
    public boolean isSeguro() {return seguro;}
    public String getDataInicial() {return dataIncial;}
    public String getDataFinal() {return dataFinal;}
    
    //seters
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }
    
    public void setDataInicial(String dataInicial) {
        this.dataIncial = dataInicial;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

	@Override
	public String toString() {
		return "Código: " + codigoLocacao + "\n" +"Cliente: " + this.cliente.getNome() + ", Veiculo: " + this.veiculo.getPlaca() + ", Seguro: " + seguro + ", Data Incial: "
				+ dataIncial + ", Data Final: " + dataFinal;
	}

}
