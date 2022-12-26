package gui;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MenuRelatorios {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private CadClientes listaClientes;
    private CadVeiculos listaVeiculos;
    private CadLocacoes listaLocacoes;

    private ObservableList<Cliente> clientesObs;
    private ObservableList<Veiculo> veiculosObs;
    private ObservableList<Locacao> locacoesObs;

    @FXML
    private TableColumn<Locacao, String> colunaCliente;

    @FXML
    private TableColumn<Locacao, String> colunaDataFinal;

    @FXML
    private TableColumn<Locacao, String> colunaDataInicial;

    @FXML
    private TableColumn<Locacao, String> colunaSeguro;

    @FXML
    private TableColumn<Locacao, String> colunaVeiculo;

    @FXML
    private ComboBox<Cliente> comboBoxClientes;

    @FXML
    private ComboBox<Veiculo> comboBoxVeiculo;

    @FXML
    private DatePicker dataLocacao;

    @FXML
    private TableView<Locacao> tabelaRelatorio;

    @FXML
    void verificarRelatorio(ActionEvent event) {
        try {
            Cliente c = this.comboBoxClientes.getSelectionModel().getSelectedItem();
            Veiculo v = this.comboBoxVeiculo.getSelectionModel().getSelectedItem();

            LocalDate data = dataLocacao.getValue();
            String dataFormatada = data.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            String dataInt = dataFormatada;
            dataInt = dataInt.replace("-", "");

            if (locacoesObs.toString().contains(dataInt)) {

                colunaVeiculo.setCellValueFactory(new PropertyValueFactory<Locacao, String>("veiculo"));
                colunaCliente.setCellValueFactory(new PropertyValueFactory<Locacao, String>("cliente"));
                colunaDataInicial.setCellValueFactory(new PropertyValueFactory<Locacao, String>("dataInicial"));
                colunaDataFinal.setCellValueFactory(new PropertyValueFactory<Locacao, String>("dataFinal"));
                colunaSeguro.setCellValueFactory(new PropertyValueFactory<Locacao, String>("seguro"));

                tabelaRelatorio.setItems(locacoesObs);
            }

            if (locacoesObs.toString().contains(c.getNome())) {

                colunaVeiculo.setCellValueFactory(new PropertyValueFactory<Locacao, String>("veiculo"));
                colunaCliente.setCellValueFactory(new PropertyValueFactory<Locacao, String>("cliente"));
                colunaDataInicial.setCellValueFactory(new PropertyValueFactory<Locacao, String>("dataInicial"));
                colunaDataFinal.setCellValueFactory(new PropertyValueFactory<Locacao, String>("dataFinal"));
                colunaSeguro.setCellValueFactory(new PropertyValueFactory<Locacao, String>("seguro"));

                tabelaRelatorio.setItems(locacoesObs);
            }

            if (locacoesObs.toString().contains(v.getPlaca())) {

                colunaVeiculo.setCellValueFactory(new PropertyValueFactory<Locacao, String>("veiculo"));
                colunaCliente.setCellValueFactory(new PropertyValueFactory<Locacao, String>("cliente"));
                colunaDataInicial.setCellValueFactory(new PropertyValueFactory<Locacao, String>("dataInicial"));
                colunaDataFinal.setCellValueFactory(new PropertyValueFactory<Locacao, String>("dataFinal"));
                colunaSeguro.setCellValueFactory(new PropertyValueFactory<Locacao, String>("seguro"));

                tabelaRelatorio.setItems(locacoesObs);
            }
        } catch (Exception e) {
        }
    }

    @FXML
    void voltarMenuInicial(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MenuLocacoes.fxml"));
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

        comboBoxClientes.setItems(clientesObs);
        comboBoxVeiculo.setItems(veiculosObs);
    }
}