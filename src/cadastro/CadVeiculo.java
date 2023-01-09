package cadastro;

import java.util.LinkedList;
import construtores.Veiculo;
import exceptions.AnoInvalidoException;
import exceptions.ListaVeiculosVaziaException;
import exceptions.ValorDiariaException;
import exceptions.VeiculoInexistenteException;
import interfaces.IVeiculos;

/**
 * Classe permite o cadastro e manutenção de um ou mais veículos.
 * Implementa a interface IVeiculos
 */
public class CadVeiculo implements IVeiculos {
 
	private LinkedList<Veiculo> veiculos;
	
	public CadVeiculo () {
		veiculos = new LinkedList<Veiculo>();
	}
	
	public void add(Veiculo v) {
		veiculos.add(v);
	}

	public Veiculo get(String placa) {
        for(Veiculo v: veiculos) {
        	if(v.getPlaca().equals(placa)) {
        		return v;
        	}
        }
        return null;
	}

	public String getInfo(String placa) {
        for(Veiculo v: veiculos) {
        	if(v.getPlaca().equals(placa)) {
        		return v.toString();
        	}
        }
        return null;
	}

	public String getInfo() {
		String dados = "";
		for(Veiculo v: veiculos) {
			dados += v.toString() +"\n";
		}
		return dados;
	}

	public String getResumoInfo() {
        String dados = "";
        for(Veiculo v: veiculos){
            dados += v.resumoInfo();
        }
        return dados;
	}

	public boolean remove(String placa) {
		Veiculo v = get(placa);
		veiculos.remove(v);
		return true;
	}

	public boolean existe(String placa) throws VeiculoInexistenteException {
		for(Veiculo v: veiculos) {
        	if(v.getPlaca().equals(placa))
        		return true;
		}
        throw new VeiculoInexistenteException();
	}
	
    public LinkedList<Veiculo> getListaVeiculos() {
    	return veiculos;
    }
    
	/** 
	 * Verifica se o valor da diária informado é um dado válido.
	 * Para verificar o método converte a String recebida para um parâmetro tipo double.
	 * @param valor a ser verificado.
	 * @return True caso a String valor possa ser convertida em uma variável do tipo double.
	 * @throws ValorDiariaException caso o valor informado não seja válido.
	 */
	public boolean verificaValorDiaria(String valor) throws ValorDiariaException {
        try {
            Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            throw new ValorDiariaException();
        }
    }
       
	/** 
	 * Verifica se o ano informado para o veículo é valido.
	 * @param ano do veículo a ser cadastrado.
	 * @return True para um ano válido.
	 * @throws AnoInvalidoException caso a String ano não seja válida.
	 */
	public boolean verificaAno(String ano) throws AnoInvalidoException {
    	if(ano.contains(" ")) {
    		throw new AnoInvalidoException();
    	}
    	
    	return true;
    }
    
	/** 
	 * Verifica se existe veículo cadastrado e adcionado a lista veiculos.
	 * @return true se exista um ou mais veiculos na lista veiculos.
	 * @throws ListaVeiculosVaziaException caso a lista veiculos esteja vazia.
	 */
	public boolean existeVeiculoCadastrado() throws ListaVeiculosVaziaException {
    	if (veiculos.isEmpty()==true) {
    		throw new ListaVeiculosVaziaException();
    	}
    	return true;
    }
	
}
