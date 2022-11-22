package gui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import cadastramentos.*;
import construtores.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Classe responsável por controlar a interface gráfica JavaFX ( Controller )
 */
public class MenuLocacoes implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private CadClientes listaClientes;
    private CadVeiculos listaVeiculos;
    private CadLocacoes listaLocacoes;

    public MenuLocacoes() {
    }

    public MenuLocacoes(CadLocacoes listaLocacoes, CadVeiculos listaVeiculos, CadClientes listaClientes) {
        this.listaClientes = listaClientes;
        this.listaVeiculos = listaVeiculos;
        this.listaLocacoes = listaLocacoes;
    }

    // Cadastro Locação
    @FXML
    private TableView<?> tblVeiculoCliente;
    
    @FXML
    private DatePicker dataFimLocacao;

    @FXML
    private DatePicker dataInicLocacao;

    @FXML
    private TextField nomeClienteLocacao;

    @FXML
    private Label valorDiaLocacao;

    @FXML
    void voltarMenuInicial(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("layoutInicio.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void Confirmar (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("layoutInicio.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void getDataFinalLocacao(ActionEvent event) {

        LocalDate dataFinal = dataFimLocacao.getValue();
        String dataFinalFormatada = dataFinal.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println(dataFinalFormatada);
    }

    @FXML
    public void getDataInicialLocacao(ActionEvent event) {
        LocalDate dataInicial = dataInicLocacao.getValue();
        String dataInicialFormatada = dataInicial.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println(dataInicialFormatada);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        carregaComboBox();

    }

    @FXML
    private ComboBox<Cliente> comboBoxClientes;

    @FXML
    private ComboBox<Veiculo> comboBoxVeiculo;

    private ObservableList<Cliente> obsListCliente;
    private ObservableList<Veiculo> obsListVeiculo;

    private List<Cliente> listaClientes2 = new ArrayList<>();
    private List<Veiculo> listaVeiculos2 = new ArrayList<>();

    Cliente c1 = new Cliente("Pablo G", "123", "258", "Rua A", "5599");
    Cliente c2 = new Cliente("Astolfo R", "321", "963", "Rua B", "5588");

    Veiculo v1 = new Onibus(30, "Viagem", false, false, "abc1234", 2022, 150);
    Veiculo v2 = new Carro(5, 5, 15, true,"cba4321", 2021, 200);

    public void carregaComboBox() {

        listaClientes2.add(c2);
        listaClientes2.add(c1);
        listaVeiculos2.add(v2);
        listaVeiculos2.add(v1);

        obsListCliente = FXCollections.observableArrayList(listaClientes2);
        obsListVeiculo = FXCollections.observableArrayList(listaVeiculos2);
        
        comboBoxClientes.setItems(obsListCliente);
        comboBoxVeiculo.setItems(obsListVeiculo);
    }

    public void getValorDiaria(ActionEvent event) {

        Period periodo = Period.between(dataInicLocacao.getValue(), dataFimLocacao.getValue());
        int dias = periodo.getDays();
        int meses = periodo.getMonths();
        int anos = periodo.getYears();

        int total = (meses * 30) + (anos * 365) + dias;
        int valorDiaLocacaoVeiculo = total * v1.getValorDiaria();
        valorDiaLocacao.setText("Valor é R$" + valorDiaLocacaoVeiculo);

    }
}