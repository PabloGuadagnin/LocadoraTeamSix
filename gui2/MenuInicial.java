package gui2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuInicial {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button botaoLocacao;

    @FXML
    void cadastrarClientes(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("MenuClientes.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void cadastrarLocacao(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("MenuLocacoes.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void cadastrarVeiculos(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("MenuVeiculos.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        assert botaoLocacao != null
                : "fx:id=\"botaoLocacao\" was not injected: check your FXML file 'MenuInicial.fxml'.";

    }

}
