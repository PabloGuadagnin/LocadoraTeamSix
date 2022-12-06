package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class MenuLocacoes {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<?> comboBoxClientes;

    @FXML
    private ComboBox<?> comboBoxVeiculo;

    @FXML
    private DatePicker dataFimLocacao;

    @FXML
    private DatePicker dataInicLocacao;

    @FXML
    private TableView<?> tblVeiculoCliente;

    @FXML
    private Label valorDiaLocacao;

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
    void getValorDiaria(ActionEvent event) {

    }

    @FXML
    void voltarMenuInicial(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MenuInicial.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        assert comboBoxClientes != null
                : "fx:id=\"comboBoxClientes\" was not injected: check your FXML file 'MenuLocacoes.fxml'.";
        assert comboBoxVeiculo != null
                : "fx:id=\"comboBoxVeiculo\" was not injected: check your FXML file 'MenuLocacoes.fxml'.";
        assert dataFimLocacao != null
                : "fx:id=\"dataFimLocacao\" was not injected: check your FXML file 'MenuLocacoes.fxml'.";
        assert dataInicLocacao != null
                : "fx:id=\"dataInicLocacao\" was not injected: check your FXML file 'MenuLocacoes.fxml'.";
        assert tblVeiculoCliente != null
                : "fx:id=\"tblVeiculoCliente\" was not injected: check your FXML file 'MenuLocacoes.fxml'.";
        assert valorDiaLocacao != null
                : "fx:id=\"valorDiaLocacao\" was not injected: check your FXML file 'MenuLocacoes.fxml'.";

    }

}
