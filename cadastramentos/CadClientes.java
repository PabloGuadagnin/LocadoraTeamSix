package cadastramentos;

import java.util.ArrayList;

/**
 * Classe resposável pela inclusão, remoção e  capturação de dados dos clientes da lista de clientes.
 * 
 * @implaments IClientes
 */

import construtores.Cliente;
import interfaces.IClientes;

public class CadClientes implements IClientes {

    private ArrayList<Cliente> listaClientes;
 
    public CadClientes() {
    	this.listaClientes = new ArrayList<>();
    }

    @Override
    public void add(Cliente c) {
        try {
            listaClientes.add(c);
        } catch (Exception e) {
            System.out.println("Ocorreu o erro: " + e);
        }
    }

    public Cliente get(long CPF) {
        for (Cliente c : listaClientes)
            if (c.getCpf() == CPF)
                return c;
        return null;
    }

    @Override
    public String getInfo(long CPF) {
        for (Cliente c : listaClientes)
            if (c.getCpf() == CPF)
                return c.toString();
        return null;
    }

    @Override
    public String getInfo() {
    	String dados = "";
        for (Cliente c : listaClientes)
        	dados+= c.toString() + "\n";
        return dados;
    }

    @Override
    public String getResumoInfo() {
        String dados = "";
        for (Cliente c : listaClientes)
            dados += "CPF: " + c.getCpf() + " e Nome: " + c.getNome() +"\n";
        return dados;
    }

    @Override
    public boolean remove(long CPF) {
        Cliente c = get(CPF);
        listaClientes.remove(c);
        return true;
    }

    @Override
    public boolean existe(long CPF) {
        for (Cliente c : listaClientes)
            if (c.getCpf() == CPF)
                return true;
        return false;
    }

    public boolean existeCnh(long CNH) {
        for (Cliente c : listaClientes)
            if (c.getCnh() == CNH)
                return true;
        return false;
    }

    public void alterarNome(long cpf, String nome) {
    	Cliente c = get(cpf);
    	c.setNome(nome);    	
    }
    
    public ArrayList<Cliente> getListaCLientes(){
    	return listaClientes;
    }

    public int size() {
        return listaClientes.size();
    }
}
