package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import cadastramentos.CadVeiculos;
import construtores.Veiculo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MenuVeiculos {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField anoVeiculo;

    @FXML
    private ChoiceBox<?> escolherTipoVeiculo2;

    @FXML
    private TextField placaVeiculo;

    @FXML
    private TableView<?> tblVeiculos;

    @FXML
    private TextField valorDiaVeiculo;

    private CadVeiculos listaVeiculos;

    @FXML
    void confirmarCadastro(ActionEvent event) {
        if (this.anoVeiculo.getText().equals("") || this.placaVeiculo.getText().equals("") ||this.valorDiaVeiculo.getText().equals("") ) {
            JOptionPane.showMessageDialog(null,"Todos os campos são obrigatórios.");
        }else{
            try {
                if(listaVeiculos.existe(placaVeiculo.getText())){
                        JOptionPane.showMessageDialog(null,
                        "A placa já existe no banco de dados.");
                }else{
                        int ano = Integer.parseInt(this.anoVeiculo.getText());
                        int valorDiaria = Integer.parseInt(this.valorDiaVeiculo.getText());
                        Veiculo novoVeiculo = new Veiculo(this.placaVeiculo.getText(), ano,valorDiaria);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    @FXML
    void getTipoVeiculoMV(MouseEvent event) {

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
        assert anoVeiculo != null : "fx:id=\"anoVeiculo\" was not injected: check your FXML file 'MenuVeiculos.fxml'.";
        assert escolherTipoVeiculo2 != null
                : "fx:id=\"escolherTipoVeiculo2\" was not injected: check your FXML file 'MenuVeiculos.fxml'.";
        assert placaVeiculo != null
                : "fx:id=\"placaVeiculo\" was not injected: check your FXML file 'MenuVeiculos.fxml'.";
        assert tblVeiculos != null
                : "fx:id=\"tblVeiculos\" was not injected: check your FXML file 'MenuVeiculos.fxml'.";
        assert valorDiaVeiculo != null
                : "fx:id=\"valorDiaVeiculo\" was not injected: check your FXML file 'MenuVeiculos.fxml'.";

    }

}
