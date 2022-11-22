package cadastramentos;
import java.util.LinkedList;

import construtores.Locacao;
import interfaces.ILocacoes;

public class CadLocacoes implements ILocacoes{

    private LinkedList<Locacao> listalocacoes;

    public CadLocacoes() {
        this.listalocacoes = new LinkedList<Locacao>();
    }

    @Override
    public void add(Locacao l) {
        listalocacoes.add(l);
    }

    @Override
    public Locacao get(int codigo) {
        for ( Locacao l : listalocacoes)
            if ( l.getCodigoLocacao() == codigo)
                return l;
        return null;
    }

    @Override
    public String getInfo(int codigo) {
        for ( Locacao l : listalocacoes)
            if ( l.getCodigoLocacao() == codigo)
                return l.toString();
        return null;
    }

    @Override
    public String getInfo() {
        String dados = "";
        for ( Locacao l : listalocacoes)
            dados+= l.toString()+"\n";
        return dados;
    }

    @Override
    public boolean remove(int codigo) {
        Locacao l = get(codigo);
            listalocacoes.remove(l);
        return true;
    }

    @Override
    public boolean existe(int codigo) {
        for ( Locacao l : listalocacoes)
            if ( l.getCodigoLocacao() == codigo )
                return true;
        return false;  
    }

    
    public LinkedList<Locacao> getListaLocacoes(){
    	return listalocacoes;
    }
}
