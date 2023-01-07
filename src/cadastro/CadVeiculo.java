package cadastro;

import java.util.LinkedList;

import construtores.Cliente;
import construtores.Veiculo;
import exceptions.AnoInvalidoException;
import exceptions.ListaClienteVaziaException;
import exceptions.ListaVeiculosVaziaException;
import exceptions.ValorDiariaException;
import exceptions.VeiculoInexistenteException;
import interfaces.IVeiculos;


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
    
    public boolean verificaValorDiaria(String valor) throws ValorDiariaException {
        try {
            Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            throw new ValorDiariaException();
        }
    }
    
    public boolean verificaAno(String ano) throws AnoInvalidoException {
    	if(ano.contains(" ")) {
    		throw new AnoInvalidoException();
    	}
    	
    	return true;
    }
    
    public boolean existeVeiculoCadastrado() throws ListaVeiculosVaziaException {
    	if (veiculos.isEmpty()==true) {
    		throw new ListaVeiculosVaziaException();
    	}
    	return true;
    }
	
}
