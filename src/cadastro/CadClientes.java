package cadastro;

import java.util.LinkedList;

import construtores.Cliente;
import exceptions.CampoObrigatorioException;
import exceptions.ClienteInexistenteException;
import exceptions.CnhInvalidaException;
import exceptions.ListaClienteVaziaException;
import exceptions.NomeInvalidoException;
import interfaces.IClientes;

/**
 * Classe que permite o cadastro e manipulação de um cliente ou conjunto de clientes
 * Implementa a Interface IClientes
 */
public class CadClientes implements IClientes{

    private LinkedList<Cliente> listaclientes;
 
    public CadClientes() {
    	listaclientes = new LinkedList<Cliente>();
    }

    public void add(Cliente c) { 
        listaclientes.add(c);
    }

    public Cliente get(String CPF) {
        for (Cliente c : listaclientes)
            if (c.getCpf().equals(CPF))
                return c;
        return null;
    }

    public String getInfo(String CPF) {
        for (Cliente c : listaclientes)
            if ( c.getCpf().equals(CPF))
                return c.toString();
        return null;
    }

    public String getInfo() {
    	String dados = "";
        for (Cliente c : listaclientes) {
        	dados += c.toString() +"\n";
        }
        return dados;
    }

    public String getResumoInfo() {
        String dados = "";
        for (Cliente c : listaclientes)
            dados += "CPF:  "+c.getCpf()+" e Nome:  "+c.getNome() +"\n";
                return dados ;
    }

    public boolean remove(String CPF) {
        Cliente c = get(CPF);
            listaclientes.remove(c);
        return true;
    }

    public boolean existe(String CPF) throws ClienteInexistenteException {
        for (Cliente c : listaclientes) {
            	if (c.getCpf().equals(CPF)) {
            		return true;
            	}
        }
        throw new ClienteInexistenteException();    
    }

    public void alterarNome(String cpf, String nome) {
    	Cliente c = get(cpf);
    	c.setNome(nome);    	
    }
    
    public LinkedList<Cliente> getListaClientes() {
    	return listaclientes;
    }
    
    /** 
     * Verifica se há clientes cadastrados e adcionados à listaClientes.
     * @return True se a listaClientes não estiver vazia.
     * @throws ListaClienteVaziaException caso a listaClientes esteja vazia.
     */
    public boolean existeClienteCadastrado() throws ListaClienteVaziaException {
    	if (listaclientes.isEmpty()==true) {
    		throw new ListaClienteVaziaException();
    	}
    	return true;
    }
    
    /** 
     * Verifica se a String nome e cnh foram corretamente informados antes de cadastras um novo cliente.
     * @param nome do cliente a ser cadastrado
     * @param cnh do cliente a ser cadastrado
     * @return True se os dados 'nome' e 'cnh' atenderem os requisitos.
     * @throws CampoObrigatorioException caso A String nome ou a String cnh estiver vazia ou apenas com espaços em branco.
     * @throws CnhInvalidaException caso s String cnh apresente espeços em branco.
     * @throws NomeInvalidoException caso a String nome apresente caracteres diferetens de letras ou espaço.
     */
    public boolean verificarCamposObrigatorios(String nome, String cnh) throws CampoObrigatorioException, CnhInvalidaException, NomeInvalidoException {
		if (nome.isBlank() || cnh.isBlank()) {
			throw new CampoObrigatorioException();
		}
		
		if (cnh.contains(" ")) {
			throw new CnhInvalidaException();
		}
		
		if (!nome.matches("[a-zA-Z\\s]+")) {
			throw new NomeInvalidoException();
		}
			
		return true;
	}
    
	@Override
	public Cliente get(long CPF) {return null;}

	@Override
	public String getInfo(long CPF) {return null;}

	@Override
	public boolean remove(long CPF) {return false;}

	@Override
	public boolean existe(long CPF) {return false;} 
	
}