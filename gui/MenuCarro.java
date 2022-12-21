package gui;

import java.io.IOException;

import javax.swing.JOptionPane;

import cadastramentos.*;
import construtores.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MenuCarro {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private CadVeiculos listaVeiculos;
    private ObservableList<Veiculo> carrosObs;

    @FXML
    private TextField anoVeiculo;

    @FXML
    private ChoiceBox<?> arCond;

    @FXML
    private TextField kmL;

    @FXML
    private TextField nPassageiros;

    @FXML
    private TextField nPortas;

    @FXML
    private Button ok;

    @FXML
    private TextField placaVeiculo;

    @FXML
    private TextField valorDiaVeiculo;

    @FXML
    void cadastrasCarro(ActionEvent event) {

    }

    @FXML
    void getArCond(MouseEvent event) {

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
    void confirmarCadastro(ActionEvent event) {
        if (this.anoVeiculo.getText().equals("") || this.placaVeiculo.getText().equals("")
                || this.valorDiaVeiculo.getText().equals("") || this.nPassageiros.getText().equals("")
                || this.kmL.getText().equals("") || this.nPortas.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios.");
        } else {
            try {
                if (listaVeiculos.existe(placaVeiculo.getText())) {
                    JOptionPane.showMessageDialog(null,
                            "A placa já existe no banco de dados.");
                } else {
                    Veiculo novoCarro = new Carro(Integer.parseInt(this.nPassageiros.getText()), 0, 0, false, null, 0, 0);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Utilize apenas números nos campos numéricos");
            }
        }
    }

    /**
     * Método que "substitui" o construtor em JavaFX, este, responsável pelas
     * construções das listas e afins.
     */
    @FXML
    void initialize() {
        listaVeiculos = MenuInicial.getListaVeiculos();

        carrosObs = MenuInicial.getObsListaVeiculos();
    }
}
