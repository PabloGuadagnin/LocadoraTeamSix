package cadastro;

import java.util.LinkedList;

import construtores.Cliente;
import excepitions.ClienteInexistenteException;
import excepitions.ListaClienteVaziaException;
import interfaces.IClientes;

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
    
    public boolean existeClienteCadastrado() throws ListaClienteVaziaException {
    	if (listaclientes.isEmpty()==true) {
    		throw new ListaClienteVaziaException();
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