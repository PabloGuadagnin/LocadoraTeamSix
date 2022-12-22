package gui;

import java.io.IOException;

import javax.swing.JOptionPane;

import cadastramentos.CadVeiculos;
import construtores.Carro;
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

public class MenuCarro {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private CadVeiculos listaVeiculos;
    private ObservableList<Veiculo> veiculosObs;

    private boolean finalArCond;

    @FXML
    private TextField anoVeiculo;

    @FXML
    private ChoiceBox<String> arCond;

    private String[] escolha = { "Sim", "Não" };

    @FXML
    private TextField kmL;

    @FXML
    private TextField nPassageiros;

    @FXML
    private TextField nPortas;

    @FXML
    private TextField placaVeiculo;

    @FXML
    private TextField valorDiaVeiculo;

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
                    Veiculo novoCarro = new Carro(Integer.parseInt(this.nPassageiros.getText()),
                            Integer.parseInt(this.nPortas.getText()), Integer.parseInt(this.kmL.getText()), finalArCond,
                            this.placaVeiculo.getText(), Integer.parseInt(this.anoVeiculo.getText()),
                            Integer.parseInt(this.valorDiaVeiculo.getText()));

                    this.veiculosObs.add(novoCarro);

                    this.listaVeiculos.add(novoCarro);

                    this.nPassageiros.clear();
                    this.nPortas.clear();
                    this.kmL.clear();
                    this.placaVeiculo.clear();
                    this.anoVeiculo.clear();
                    this.valorDiaVeiculo.clear();
                    this.arCond.setValue(null);

                    placaVeiculo.requestFocus();

                    JOptionPane.showMessageDialog(null, "Carro placa "
                            + novoCarro.getPlaca() + " cadastrado com sucesso.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Utilize apenas números inteiros\n nos campos numéricos");
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

        veiculosObs = MenuInicial.getObsListaVeiculos();

        arCond.getItems().addAll(escolha);
        arCond.setOnAction(this::getEscolharArCond);
    }

    public void getEscolharArCond(ActionEvent event) {
        String escolhaAr = arCond.getValue();

        if (escolhaAr == "Sim") {
            finalArCond = true;
        } else {
            finalArCond = false;
        }
    }
}
