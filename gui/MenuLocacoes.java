package gui;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

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
import javafx.scene.control.ChoiceBox;
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

    private int cod = 1;
    private boolean finalEscolhaSeguro;

    @FXML
    private ComboBox<Cliente> comboBoxClientes;

    @FXML
    private ComboBox<Veiculo> comboBoxVeiculo;

    @FXML
    private ChoiceBox<String> seguro;

    private String[] escolha = { "Sim", "Não" };

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
        Cliente c = this.comboBoxClientes.getSelectionModel().getSelectedItem();
        Veiculo v = this.comboBoxVeiculo.getSelectionModel().getSelectedItem();

        LocalDate dataInicial = dataInicLocacao.getValue();
        String dataInicialFormatada = dataInicial.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String dataInicialInt = dataInicialFormatada;
        dataInicialInt = dataInicialInt.replace("-", "");

        LocalDate dataFinal = dataFimLocacao.getValue();
        String dataFinalFormatada = dataFinal.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String dataFinalInt = dataFinalFormatada;
        dataFinalInt = dataFinalInt.replace("-", "");

        Locacao novaLocacao = new Locacao(cod, c, v, finalEscolhaSeguro, Integer.parseInt(dataInicialInt),
                Integer.parseInt(dataFinalInt));

        this.locacoesObs.add(novaLocacao);

        this.listaLocacoes.add(novaLocacao);

        this.comboBoxClientes.setValue(null);
        this.comboBoxVeiculo.setValue(null);
        this.seguro.setValue(null);
        this.dataInicLocacao.setValue(null);
        this.dataFimLocacao.setValue(null);
        this.valorDiaLocacao.setText("Selecione o Período e Veículo");

        JOptionPane.showMessageDialog(null, "Locação código "
                + novaLocacao.getCodigoLocacao() + " cadastrada com sucesso.");

        cod++;
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

        comboBoxClientes.setItems(clientesObs);
        comboBoxVeiculo.setItems(veiculosObs);

        tblVeiculoCliente.setItems(locacoesObs);

        seguro.getItems().addAll(escolha);
        seguro.setOnAction(this::getEscolharSeguro);
    }

    public void getEscolharSeguro(ActionEvent event) {
        String escolhaSeguro = seguro.getValue();

        if (escolhaSeguro == "Sim") {
            finalEscolhaSeguro = true;
        } else {
            finalEscolhaSeguro = false;
        }
    }

    @FXML
    void valorTotalLocacao(ActionEvent event) {
        try {
            Veiculo v = this.comboBoxVeiculo.getSelectionModel().getSelectedItem();

            Period periodo = Period.between(dataInicLocacao.getValue(), dataFimLocacao.getValue());
            int dias = periodo.getDays();
            int meses = periodo.getMonths();
            int anos = periodo.getYears();

            int total = (meses * 30) + (anos * 365) + dias;
            int valorDiaLocacaoVeiculo = total * v.getValorDiaria();
            valorDiaLocacao.setText("Valor é R$" + valorDiaLocacaoVeiculo);
        } catch (Exception e) {
        }
    }
}