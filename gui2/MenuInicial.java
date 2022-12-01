package gui2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuInicial {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button botaoLocacao;

    @FXML
    void cadastrarClientes(ActionEvent event) {

    }

    @FXML
    void cadastrarLocacao(ActionEvent event) {

    }

    @FXML
    void cadastrarVeiculos(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert botaoLocacao != null : "fx:id=\"botaoLocacao\" was not injected: check your FXML file 'MenuInicial.fxml'.";

    }

}
