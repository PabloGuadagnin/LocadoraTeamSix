package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import cadastramentos.CadVeiculos;
import construtores.Veiculo;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
        private TableColumn colunaAno;

        @FXML
        private TableColumn colunaPlaca;

        @FXML
        private TextField anoVeiculo;

        @FXML
    public ChoiceBox<String> escolherTipoVeiculo2 = new ChoiceBox<>();
    public String[] tipoVeiculo2 = { "Carro", "Caminhão", "Ônibus" };

        @FXML
        private TextField placaVeiculo;

        @FXML
        private TableView<Veiculo> tblVeiculos;

        @FXML
        private TextField valorDiaVeiculo;

        private CadVeiculos listaVeiculos;

        @FXML
        void confirmarCadastro(ActionEvent event) {
                if (this.anoVeiculo.getText().equals("") || this.placaVeiculo.getText().equals("")
                                || this.valorDiaVeiculo.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios.");
                } else {
                        try {
                                if (listaVeiculos.existe(placaVeiculo.getText())) {
                                        JOptionPane.showMessageDialog(null,
                                                        "A placa já existe no banco de dados.");
                                } else {
                                        int ano = Integer.parseInt(this.anoVeiculo.getText());
                                        int valorDiaria = Integer.parseInt(this.valorDiaVeiculo.getText());
                                        Veiculo novoVeiculo = new Veiculo(this.placaVeiculo.getText(), ano,
                                                        valorDiaria);
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

        public void getTipoVeiculoMV(ActionEvent event) {

                String tipoVeiculo2 = escolherTipoVeiculo2.getValue();
                System.out.println(tipoVeiculo2);
        
            }

        @FXML
        void initialize() {
                assert anoVeiculo != null
                                : "fx:id=\"anoVeiculo\" was not injected: check your FXML file 'MenuVeiculos.fxml'.";
                assert escolherTipoVeiculo2 != null
                                : "fx:id=\"escolherTipoVeiculo2\" was not injected: check your FXML file 'MenuVeiculos.fxml'.";
                assert placaVeiculo != null
                                : "fx:id=\"placaVeiculo\" was not injected: check your FXML file 'MenuVeiculos.fxml'.";
                assert tblVeiculos != null
                                : "fx:id=\"tblVeiculos\" was not injected: check your FXML file 'MenuVeiculos.fxml'.";
                assert valorDiaVeiculo != null
                                : "fx:id=\"valorDiaVeiculo\" was not injected: check your FXML file 'MenuVeiculos.fxml'.";

                /**
                 * Método que "substitui" o construtor em JavaFX, este, responsável pelas
                 * construções das listas e afins.
                 */

                listaVeiculos = MenuInicial.getListaVeiculos();

                veiculosObs = MenuInicial.getObsListaVeiculos();

                colunaAno.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("ano"));
                colunaPlaca.setCellValueFactory(new PropertyValueFactory<Veiculo, String>("placa"));

                tblVeiculos.setItems(veiculosObs);

                escolherTipoVeiculo2.getItems().addAll(tipoVeiculo2);
        escolherTipoVeiculo2.setOnAction(this::getTipoVeiculoMV);
        }
}