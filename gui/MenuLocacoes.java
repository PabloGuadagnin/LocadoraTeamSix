package gui;

import java.io.IOException;

import cadastramentos.CadClientes;
import cadastramentos.CadLocacoes;
import cadastramentos.CadVeiculos;
import construtores.Cliente;
import construtores.Locacao;
import construtores.Veiculo;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MenuLocacoes {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ComboBox<?> comboBoxClientes;

    @FXML
    private ComboBox<?> comboBoxVeiculo;

    @FXML
    private DatePicker dataFimLocacao;

    @FXML
    private DatePicker dataInicLocacao;

    @FXML
    private TableView<Locacao> tblVeiculoCliente;

    @FXML
    private TableColumn<Locacao, String> colunaVeiculo;

    @FXML
    private TableColumn<Locacao, String> colunaCliente;

    @FXML
    private Label valorDiaLocacao;

    private CadClientes listaClientes;
    private CadVeiculos listaVeiculos;
    private CadLocacoes listaLocacoes;

    private ObservableList<Cliente> clientesObs;
    private ObservableList<Veiculo> veiculosObs;
    private ObservableList<Locacao> locacoesObs;

    @FXML
    void Confirmar(ActionEvent event) {

    }

    @FXML
    void getDataFinalLocacao(ActionEvent event) {

    }

    @FXML
    void getDataInicialLocacao(ActionEvent event) {

    }

    @FXML
    void voltarMenuInicial(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MenuInicial.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Método que "substitui" o construtor em JavaFX, este, responsável pelas
     * construções das listas e afins.
     */
    @FXML
    void initialize() {

        listaClientes = MenuInicial.getListaClientes();
        clientesObs = MenuInicial.getObsListaClietnes();

        listaVeiculos = MenuInicial.getListaVeiculos();
        veiculosObs = MenuInicial.getObsListaVeiculos();

        listaLocacoes = MenuInicial.getListaLocacoes();
        locacoesObs = MenuInicial.getObsListaLocacoes();

        colunaVeiculo.setCellValueFactory(new PropertyValueFactory<Locacao, String>("veiculo"));
        colunaCliente.setCellValueFactory(new PropertyValueFactory<Locacao, String>("cliente"));
    }

}
