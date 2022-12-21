package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import cadastramentos.CadVeiculos;
import construtores.Onibus;
import construtores.Veiculo;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MenuOnibus {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private CadVeiculos listaVeiculos;
    private ObservableList<Veiculo> veiculosObs;

    private boolean finalArCond;
    private boolean finalWiFi;
    private String finalCategoria;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> arCond;

    @FXML
    private ChoiceBox<String> categoria;

    @FXML
    private ChoiceBox<String> wifi;

    private String[] simOuNao = { "Sim", "Não" };
    private String[] categoriaOnibus = { "Leito", "Executivo", "Convencional" };

    @FXML
    private TextField anoVeiculo;

    @FXML
    private TextField nPassageiros;

    @FXML
    private TextField placaVeiculo;

    @FXML
    private TextField valorDiaVeiculo;

    @FXML
    void confirmarCadastro(ActionEvent event) {
        if (this.anoVeiculo.getText().equals("") || this.placaVeiculo.getText().equals("")
                || this.valorDiaVeiculo.getText().equals("") || this.nPassageiros.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios.");
        } else {
            try {
                if (listaVeiculos.existe(placaVeiculo.getText())) {
                    JOptionPane.showMessageDialog(null,
                            "A placa já existe no banco de dados.");
                } else {
                    Veiculo novoOnibus = new Onibus(Integer.parseInt(this.nPassageiros.getText()), finalCategoria,
                            finalWiFi,
                            finalArCond,
                            this.placaVeiculo.getText(), Integer.parseInt(this.anoVeiculo.getText()),
                            Integer.parseInt(this.valorDiaVeiculo.getText()));

                    this.veiculosObs.add(novoOnibus);

                    this.listaVeiculos.add(novoOnibus);

                    this.nPassageiros.clear();
                    this.placaVeiculo.clear();
                    this.anoVeiculo.clear();
                    this.valorDiaVeiculo.clear();
                    this.arCond.setValue(null);
                    this.categoria.setValue(null);
                    this.wifi.setValue(null);

                    placaVeiculo.requestFocus();

                    JOptionPane.showMessageDialog(null, "Ônibus placa "
                            + novoOnibus.getPlaca() + " cadastrado com sucesso.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Utilize apenas números inteiros\n nos campos numéricos");
            }
        }

    }

    @FXML
    void voltarMenuInicial(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MenuVeiculos.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        listaVeiculos = MenuInicial.getListaVeiculos();

        veiculosObs = MenuInicial.getObsListaVeiculos();

        arCond.getItems().addAll(simOuNao);
        arCond.setOnAction(this::getEscolharArCond);

        wifi.getItems().addAll(simOuNao);
        wifi.setOnAction(this::getEscolhaWiFi);

        categoria.getItems().addAll(categoriaOnibus);
        categoria.setOnAction(this::getCategoria);
    }

    public void getEscolharArCond(ActionEvent event) {
        String escolhaAr = arCond.getValue();

        if (escolhaAr == "Sim") {
            finalArCond = true;
        } else {
            finalArCond = false;
        }
    }

    public void getEscolhaWiFi(ActionEvent event) {
        String escolhaWiFi = wifi.getValue();

        if (escolhaWiFi == "Sim") {
            finalWiFi = true;
        } else {
            finalWiFi = false;
        }
    }

    public void getCategoria(ActionEvent event) {
        finalCategoria = categoria.getValue();
    }
}
