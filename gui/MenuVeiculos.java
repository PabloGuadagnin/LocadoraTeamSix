package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import construtores.Veiculo;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MenuVeiculos {
        private ObservableList<Veiculo> veiculosObs;
        private Stage stage;
        private Scene scene;
        private Parent root;

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private TableColumn<Veiculo, String> colunaAno;

        @FXML
        private TableColumn<Veiculo, String> colunaPlaca;

        @FXML
        private TableView<Veiculo> tblVeiculos;

        @FXML
        void menuCaminhao(ActionEvent event) throws IOException {
                root = FXMLLoader.load(getClass().getResource("MenuCaminhao.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }

        @FXML
        void menuCarro(ActionEvent event) throws IOException {
                root = FXMLLoader.load(getClass().getResource("MenuCarro.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }

        @FXML
        void menuOnibus(ActionEvent event) throws IOException {
                root = FXMLLoader.load(getClass().getResource("MenuOnibus.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }

        /**
         * @param event
         * @throws IOException
         */
        @FXML
        void voltarMenuInicial(ActionEvent event) throws IOException {
                root = FXMLLoader.load(getClass().getResource("MenuInicial.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }

        /**
         * Método que "substitui" o construtor em JavaFX, este, responsável pelas
         * construções das listas e afins.
         */
        @FXML
        void initialize() {
                veiculosObs = MenuInicial.getObsListaVeiculos();

                colunaAno.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("ano"));
                colunaPlaca.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("placa"));

                tblVeiculos.setItems(veiculosObs);
        }
}