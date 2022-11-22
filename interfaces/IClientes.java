package interfaces;

import construtores.Cliente;

/**
 * Interface que permite a manipulação de um conjunto de clientes.
 * @author Aline
 */
public interface IClientes {
    /**
     * Adiciona um cliente na relação de clientes.
     * @param c Cliente a ser inserido.
     */
    public void add(Cliente c);
    
    /**
     * Captura o cliente com o CPF informado por parâmetro.
     * @param CPF CPF do cliente a ser capturado.
     * @return Cliente com o CPF informado ou null caso o CPF não for encontrado.
     */
    public Cliente get(String CPF);
    
    /**
     * Captura uma String com as informaçoes do cliente com CPF informado por parâmetro.
     * @param CPF CPF do cliente a ser capturado.
     * @return String com as informaçoes do cliente com o CPF informado por parâmetro 
     * ou null caso o CPF não for encontrado.
     */
    public String getInfo(String CPF);
    
    /**
     * Captura uma String com as informaçoes de todos os clientes.
     * @return String com as informaçoes de todos os clientes
     * ou null caso não exista nenhum cliente.
     */
    public String getInfo();
    
    /**
     * Captura uma String com o CPF e o nome de todos os clientes.
     * @return String com o CPF e o nome de todos os clientes
     * ou null caso não exista nenhum cliente.
     */
    public String getResumoInfo();
    
    /**
     * Remove o cliente com o CPF igual ao informado por parâmetro.
     * @param CPF CPF do cliente a ser capturado.
     * @return True se o cliente com o CPF informado por parâmetro for removido ou
     * false caso não exista nenhum cliente com o CPF informado. 
     */
    public boolean remove(String CPF);
    
    /**
     * Verifica se existe um cliente com o CPF informado por parâmetro.
     * @param CPF CPF do cliente a ser verificado.
     * @return True se um cliente com o CPF informado for encontrado ou 
     * false caso não exista nenhum cliente com o CPF informado.
     */
    public boolean existe(String CPF);
}