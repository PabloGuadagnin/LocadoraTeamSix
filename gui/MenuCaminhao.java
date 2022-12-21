package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import cadastramentos.CadVeiculos;
import construtores.Caminhao;
import construtores.Veiculo;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MenuCaminhao {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private CadVeiculos listaVeiculos;
    private ObservableList<Veiculo> veiculosObs;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField anoVeiculo;

    @FXML
    private TextField cargaMax;

    @FXML
    private TextField nEixos;

    @FXML
    private TextField placaVeiculo;

    @FXML
    private TextField valorDiaVeiculo;

    @FXML
    void confirmarCadastro(ActionEvent event) {

        if (this.anoVeiculo.getText().equals("") || this.placaVeiculo.getText().equals("")
                || this.valorDiaVeiculo.getText().equals("") || this.cargaMax.getText().equals("")
                || this.nEixos.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios.");
        } else {
            try {
                if (listaVeiculos.existe(placaVeiculo.getText())) {
                    JOptionPane.showMessageDialog(null,
                            "A placa já existe no banco de dados.");
                } else {
                    Veiculo novoCaminhao = new Caminhao(Integer.parseInt(this.nEixos.getText()),
                            Integer.parseInt(this.cargaMax.getText()), this.placaVeiculo.getText(),
                            Integer.parseInt(this.anoVeiculo.getText()),
                            Integer.parseInt(this.valorDiaVeiculo.getText()));

                    this.veiculosObs.add(novoCaminhao);

                    this.listaVeiculos.add(novoCaminhao);

                    this.cargaMax.clear();
                    this.nEixos.clear();
                    this.placaVeiculo.clear();
                    this.anoVeiculo.clear();
                    this.valorDiaVeiculo.clear();

                    placaVeiculo.requestFocus();

                    JOptionPane.showMessageDialog(null, "Caminhão placa "
                            + novoCaminhao.getPlaca() + " cadastrado com sucesso.");
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
    }

}
