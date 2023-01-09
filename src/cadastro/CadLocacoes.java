package cadastro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import construtores.Locacao;
import exceptions.DataInvalidaException;
import exceptions.ListaLocacoesVaziaException;
import exceptions.SemLocacoesNoPeriodoException;
import exceptions.SemLocacoesParaClienteException;
import exceptions.SemLocacoesParaVeiculoException;
import exceptions.VeiculoIndisponivelException;
import interfaces.ILocacoes;

/**
 * Clesse que permite o cadastro e manipulação de uma ou mais locações.
 * Implementa a interface ILocacoes
 */
public class CadLocacoes implements ILocacoes{

	private LinkedList<Locacao> listalocacoes;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public CadLocacoes() {
        this.listalocacoes = new LinkedList<Locacao>(); 
    }

    public void add(Locacao l) {
        listalocacoes.add(l);
    }

    public Locacao get(int codigo) {
        for ( Locacao l : listalocacoes)
            if ( l.getCodigoLocacao() == codigo)
                return l;
        return null;
    }

    public String getInfo(int codigo) {
        for ( Locacao l : listalocacoes)
            if ( l.getCodigoLocacao() == codigo)
                return l.toString();
        return null;
    }

    public String getInfo() {
    	String dados = "";
        for ( Locacao l : listalocacoes) {
        	dados += l.toString() + "\n";
        }
        return dados;
    }

    public boolean remove(int codigo) {
        Locacao l = get(codigo);
            listalocacoes.remove(l);
        return true;
    }

    public boolean existe(int codigo) {
        for ( Locacao l : listalocacoes)
            if ( l.getCodigoLocacao() == codigo )
                return true;
        return false;  
    }

	/** 
	 * Verifica se há locações para um determinado cliente na lista de locações
	 * e gera uma String com os dados das locações encontradas.
	 * @param cpf do cliente a ser pesquisado
	 * @return String dados contendo as locações do cliente informado.
	 * @throws SemLocacoesParaClienteException caso não encontradas locações para o cliente na lista de locações.
	 */
	public String filtrarLocacoesCliente(String cpf) throws SemLocacoesParaClienteException {
    	String dados = "";
        for ( Locacao l : listalocacoes) {
        	if (l.getCliente().getCpf().equals(cpf)) {
        		dados += l.toString() + "\n";
        	}
        	
        }
        if(dados.isBlank())
        	throw new SemLocacoesParaClienteException();
        return dados;
	}

	/** 
	 * Verifica se há locações para um determinado veículo na lista de locações.
	 * @param placa do veículo a ser pesquisado
	 * @return String dados contento as locações do veículo informado.
	 * @throws SemLocacoesParaVeiculoException caso não encontradas locações para o cliente na liosta de locações.
	 */
	public String filtrarLocacoesVeiculo(String placa) throws SemLocacoesParaVeiculoException {
    	String dados = "";
        for ( Locacao l : listalocacoes) {
        	if (l.getVeiculo().getPlaca().equals(placa)) {
        		dados += l.toString() + "\n";
        	}
        }
        if (dados.isBlank())
        	throw new SemLocacoesParaVeiculoException();
        return dados;
	}
	
	/** 
	 * Verifica se há locações em um determinado período na lista de locações.
	 * @param dataInicial inicio do período.
	 * @param dataFinal fim do período.
	 * @return String dados contento as locações no período informado.
	 * @throws ParseException caso não seja possível a conversão e formatação da String dataInicial e dataFinal recebidas.
	 * @throws SemLocacoesNoPeriodoException caso não haja locações no período informado.
	 */
	public String filtrarLocacoesPeriodo(String dataInicial, String dataFinal) throws ParseException, SemLocacoesNoPeriodoException {
		String dados = "";
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	Date primeiraData = sdf.parse(dataInicial);
    	Date segundaData = sdf.parse(dataFinal);
	
		for (Locacao l: listalocacoes) {
			Date inicioLocacao = sdf.parse(l.getDataInicial());
			Date fimLocacao = sdf.parse(l.getDataFinal());
			
			if(primeiraData.compareTo(inicioLocacao) >=0 && primeiraData.compareTo(fimLocacao) <=0 
					|| segundaData.compareTo(inicioLocacao) >=0 && segundaData.compareTo(fimLocacao) <=0 ) {
				dados += l.toString() + "\n";
			} 
		}
		
		if(dados.isBlank())
			throw new SemLocacoesNoPeriodoException();
		return dados;	
	}
	
	/** 
	 * Verífica a disponibilidade do veículo para o periodo de locação informado. Aso cadastrar uma nova locação
	 * o método verifica se o veículo já não está locado no período solicitado.
	 * @param placa do veículo a ser locado.
	 * @param dataInicial inicio do período de locação.
	 * @param dataFinal fim do período de locação.
	 * @return True caso não haja locações para o veículo no periodo informado.
	 * @throws ParseException caso não seja possível a conversão e formatação da String dataInicial e dataFinal recebidas.
	 * @throws VeiculoIndisponivelException caso seja encontradas locação para o veiculo no mesmo período.
	 */
	public boolean verificarDisponibilidadeVeiculo(String placa, String dataInicial, String dataFinal) throws ParseException, VeiculoIndisponivelException {
		
	  	Date primeiraData = sdf.parse(dataInicial);
    	Date segundaData = sdf.parse(dataFinal);

		for (Locacao l: listalocacoes) {
			
			if (l.getVeiculo().getPlaca().equals(placa)) {
				Date inicioLocacao = sdf.parse(l.getDataInicial());
				Date fimLocacao = sdf.parse(l.getDataFinal());
				
				if(primeiraData.compareTo(inicioLocacao) >=0 && primeiraData.compareTo(fimLocacao) <=0 
						|| segundaData.compareTo(inicioLocacao) >=0 && segundaData.compareTo(fimLocacao) <=0) {
					throw new VeiculoIndisponivelException();
				}
			}
		}
		return true;			
	}
	
	/** 
	 * Verifica se a data informada é uma data válida.
	 * @param date a ser verificada
	 * @return True caso a data seja válida.
	 * @throws DataInvalidaException caso a data informada seja inválida.
	 */
	public boolean validarData(String date) throws DataInvalidaException {
        
        sdf.setLenient(false);

        try {
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            throw new DataInvalidaException();
        }  
    }
    
	/** 
	 * O método verifica se a data inicial e a data final é igual ou posterir a data atual.
	 * Verificação necessária para o cadastro de novas locações.
	 * @param dataInicial do período de locação.
	 * @param dataFinal do período de locação.
	 * @return True se as datas informadas atenderem ao requisito.
	 * @throws ParseException caso não seja possível a conversão e formatação da String dataInicial e dataFinal recebidas.
	 * @throws DataInvalidaException caso qualquer das datas informadas seja anterior a data atual.
	 */
	public boolean compararData(String dataInicial, String dataFinal) throws ParseException, DataInvalidaException {
  	
    	Date primeiraData = sdf.parse(dataInicial);
    	Date segundaData = sdf.parse(dataFinal);
    	
		Date currentDate = new Date();
		String currentDateToString = sdf.format(currentDate);
		Date dataAtual = sdf.parse(currentDateToString);
		
		if(primeiraData.compareTo(dataAtual) >=0 && segundaData.compareTo(dataAtual) >=0 && primeiraData.compareTo(segundaData) <=0) {
			return true;
		} else {
			throw new DataInvalidaException();
		}
    }
    
	/** 
	 * Verifica se a data final do período de locação é igual ou posterior a data inicial.
	 * @param dataInicial do período de locação.
	 * @param dataFinal do período de locação.
	 * @return True se a data final é igual ou posteiror a data inicial.
	 * @throws ParseException caso não seja possível a conversão e formatação da String dataInicial e dataFinal recebidas.
	 * @throws DataInvalidaException caso a data final seja anterior a data inicial informada.
	 */
	public boolean comparaDataInicialComDataFinal(String dataInicial, String dataFinal) throws ParseException, DataInvalidaException {
		
    	Date primeiraData = sdf.parse(dataInicial);
    	Date segundaData = sdf.parse(dataFinal);
    	
		if(primeiraData.compareTo(segundaData) <=0) {
			return true;
		} else {
			throw new DataInvalidaException();
		}
    }
    
	/** 
	 * Verifica se há locações cadastradas e adcionada a lista de locações.
	 * @return True se exista locações na listaLocacoes.
	 * @throws ListaLocacoesVaziaException caso a listalocacoes esteja vazia.
	 */
	public boolean existeLocacoesCadastradas() throws ListaLocacoesVaziaException {
    	if (listalocacoes.isEmpty()==true) {
    		throw new ListaLocacoesVaziaException();
    	}
    	return true;
    }
}