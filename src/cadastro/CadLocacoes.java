package cadastro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import construtores.Locacao;
import excepitions.DataInvalidaException;
import excepitions.ListaLocacoesVaziaException;
import excepitions.ListaVeiculosVaziaException;
import excepitions.SemLocacoesNoPeriodoException;
import excepitions.SemLocacoesParaClienteException;
import excepitions.SemLocacoesParaVeiculoException;
import excepitions.VeiculoIndisponivelException;
import interfaces.ILocacoes;

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
	
    public boolean validarData(String date) throws DataInvalidaException {
        
        sdf.setLenient(false);

        try {
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            throw new DataInvalidaException();
        }  
    }
    
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
    
    public boolean comparaDataInicialComDataFinal(String dataInicial, String dataFinal) throws ParseException, DataInvalidaException {
		
    	Date primeiraData = sdf.parse(dataInicial);
    	Date segundaData = sdf.parse(dataFinal);
    	
		if(primeiraData.compareTo(segundaData) <=0) {
			return true;
		} else {
			throw new DataInvalidaException();
		}
    }
    
    public boolean existeLocacoesCadastradas() throws ListaLocacoesVaziaException {
    	if (listalocacoes.isEmpty()==true) {
    		throw new ListaLocacoesVaziaException();
    	}
    	return true;
    }
}