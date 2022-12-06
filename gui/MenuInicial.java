package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import cadastramentos.CadClientes;
import cadastramentos.CadLocacoes;
import cadastramentos.CadVeiculos;
import construtores.Cliente;
import construtores.Veiculo;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/*
 * Classe Controller responsável por mapear o menu inicial do programa
 */
public class MenuInicial {

    private Stage stage;
    private Scene scene;
    private Parent root;

    // Listas que garantem a persistência de dados em JavaFX, melhor forma para se
    // obter listas em todas as telas
    private static CadClientes listaClientes;
    private static CadLocacoes listaLocacoes;
    private static CadVeiculos listaVeiculos;
    private static ObservableList<Cliente> clientesObs;
    private static ObservableList<Veiculo> veiculosObs;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button botaoLocacao;

    /**
     * Método responsável por mapear as ações do botão que inicia o menu clientes
     * 
     * @param event
     * @throws IOException
     */
    @FXML
    void cadastrarClientes(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("MenuClientes.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Método responsável por mapear as ações do botão que inicia o menu locações
     * 
     * @param event
     * @throws IOException
     */
    @FXML
    void cadastrarLocacao(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("MenuLocacoes.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Método responsável por mapear as ações do botão que inicia o menu veiculos
     * 
     * @param event
     * @throws IOException
     */
    @FXML
    void cadastrarVeiculos(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("MenuVeiculos.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Método que "substitui" o construtor em JavaFX
     */
    @FXML
    void initialize() {
        assert botaoLocacao != null
                : "fx:id=\"botaoLocacao\" was not injected: check your FXML file 'MenuInicial.fxml'.";

    }

    // Getters e Setters responsáveis por receber e enviar as listas populadas entre
    // as telas do JavaFX

    /**
     * Método setter responsável por receber a lista de clientes
     * 
     * @param listaClientesNova
     */
    public void setListaClientes(CadClientes listaClientesNova) {
        listaClientes = listaClientesNova;
    }

    /**
     * Método setter responsável por receber a lista de locações
     * 
     * @param listaLocacoesNova
     */
    public void setListaLocacoes(CadLocacoes listaLocacoesNova) {
        listaLocacoes = listaLocacoesNova;
    }

    /**
     * Método setter responsável por receber a lista de veículos
     * 
     * @param listaVeiculosNova
     */
    public void setListaVeiculos(CadVeiculos listaVeiculosNova) {
        listaVeiculos = listaVeiculosNova;
    }

    /**
     * Método setter responsável por receber a lista observável de clientes
     * 
     * @param clientesObsNova
     */
    public void setObsListaClietnes(ObservableList<Cliente> clientesObsNova) {
        clientesObs = (ObservableList<Cliente>) clientesObsNova;
    }
    /**
     * Método setter responsável por receber a lista observável de veiculos
     * 
     * @param veiculosObsNova
     */
    public void setObsListaVeiculos(ObservableList<Veiculo> veiculosObsNova) {
        veiculosObs = (ObservableList<Veiculo>) veiculosObsNova;
    }

    /**
     * Método getter responsável por retornar a lista de clientes
     * 
     * @return listaClientes
     */
    public static CadClientes getListaClientes() {
        return listaClientes;
    }

    /**
     * Método getter responsável por retornar a lista de locações
     * 
     * @return listaLocacoes
     */
    public static CadLocacoes getListaLocacoes() {
        return listaLocacoes;
    }

    /**
     * Método getter responsável por retornar a lista de veículos
     * 
     * @return listaVeiculos
     */
    public static CadVeiculos getListaVeiculos() {
        return listaVeiculos;
    }

    /**
     * Método getter responsável por retornar a lista observável de clientes
     * 
     * @return clientesObs
     */
    public static ObservableList<Cliente> getObsListaClietnes() {
        return clientesObs;
    }

    /**
     * Método getter responsável por retornar a lista observável de veiculos
     * 
     * @return veiculosObs
     */
    public static ObservableList<Veiculo> getObsListaVeiculos() {
        return veiculosObs;
    }
}