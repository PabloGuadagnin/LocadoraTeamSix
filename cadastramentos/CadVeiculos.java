package cadastramentos;

import java.util.LinkedList;

import construtores.Veiculo;
import interfaces.IVeiculos;

public class CadVeiculos implements IVeiculos {

    private LinkedList<Veiculo> listaveiculos;
    
    public CadVeiculos() {
        this.listaveiculos = new LinkedList<Veiculo>();
    }

    @Override
    public void add(Veiculo v) {
        listaveiculos.add(v);
    }

    @Override
    public Veiculo get(String placa) {
        for (Veiculo v : listaveiculos)
            if (v.getPlaca().equals(placa))
                return v;
        return null;
    }

    @Override
    public String getInfo(String placa) {
        for (Veiculo v : listaveiculos)
            if (v.getPlaca().equals(placa))
                return v.toString();
        return null;
    }

    @Override
    public String getInfo() {
    	String dados = "";
        for (Veiculo v : listaveiculos)
        	dados+= v.toString() + "\n";
        return dados;
    }

    @Override
    public String getResumoInfo() {
        String dados = "";
        for (Veiculo v : listaveiculos)
            dados += "Placa = " + v.getPlaca() + ", Ano = " + v.getAno()
                    + ", Valor da Diária = " + v.getValorDiaria()+ "\n";
        return dados;
    }

    @Override
    public boolean remove(String placa) {
        Veiculo v = get(placa);
        listaveiculos.remove(v);
        return true;
    }

    @Override
    public boolean existe(String placa) {
        for (Veiculo v : listaveiculos)
            if (v.getPlaca().equals(placa))
                return true;
        return false;
    }
}
