package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Carro {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    void cadastrasCarro(ActionEvent event) {

    }

    @FXML
    void getArCond(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert arCond != null : "fx:id=\"arCond\" was not injected: check your FXML file 'Carro.fxml'.";
        assert kmL != null : "fx:id=\"kmL\" was not injected: check your FXML file 'Carro.fxml'.";
        assert nPassageiros != null : "fx:id=\"nPassageiros\" was not injected: check your FXML file 'Carro.fxml'.";
        assert nPortas != null : "fx:id=\"nPortas\" was not injected: check your FXML file 'Carro.fxml'.";
        assert ok != null : "fx:id=\"ok\" was not injected: check your FXML file 'Carro.fxml'.";

    }

}
