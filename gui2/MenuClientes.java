package gui2;

import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

import cadastramentos.CadClientes;
import construtores.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MenuClientes {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField cnhCliente;

    @FXML
    private TextField cpfCliente;

    @FXML
    private TextField enderecoCliente;

    @FXML
    private TextField nomeCliente;

    @FXML
    private TableView<Cliente> tabelaClientes;

    @FXML
    private TableColumn colunaCPF;

    @FXML
    private TableColumn colunaNome;

    @FXML
    private TextField telefoneCliente;

    private CadClientes listaClientes;

    @FXML
    void confirmarCadastro(ActionEvent event) {

        if (this.nomeCliente.getText().equals("") || this.cpfCliente.getText().equals("") ||
                this.cnhCliente.getText().equals("") || this.enderecoCliente.getText().equals("") ||
                this.telefoneCliente.getText().equals("")) {
            JOptionPane.showMessageDialog(null,
                    "Todos os campos são obrigatórios.");
        } else {
            try {
                if (listaClientes.existe(cpfCliente.getText()) || listaClientes.existeCnh(cnhCliente.getText())) {
                    JOptionPane.showMessageDialog(null,
                            "O CPF ou CNH já existe(m) no banco de dados.");
                } else {
                    Cliente novoCliente = new Cliente(this.nomeCliente.getText(), this.cpfCliente.getText(),
                            this.cnhCliente.getText(), this.enderecoCliente.getText(), this.telefoneCliente.getText());

                    this.clientesObs.add(novoCliente);

                    this.listaClientes.add(novoCliente);

                    this.nomeCliente.clear();
                    this.cpfCliente.clear();
                    this.cnhCliente.clear();
                    this.enderecoCliente.clear();
                    this.telefoneCliente.clear();

                    nomeCliente.requestFocus();

                    JOptionPane.showMessageDialog(null, "Cliente "
                            + novoCliente.getNome() + " cadastrado com sucesso.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Entradas inválidas, corrija e envie novamente.");
            }
        }
    }

    @FXML
    void alterarObj(ActionEvent event) {
        int i = this.tabelaClientes.getSelectionModel().getSelectedIndex();

        if (i >= 0) {
            if (this.nomeCliente.getText().equals("") || this.cpfCliente.getText().equals("") ||
                    this.cnhCliente.getText().equals("") || this.enderecoCliente.getText().equals("") ||
                    this.telefoneCliente.getText().equals("")) {

                this.nomeCliente.setText(clientesObs.get(i).getNome());
                this.cpfCliente.setText(clientesObs.get(i).getCpf());
                this.cnhCliente.setText(clientesObs.get(i).getCnh());
                this.enderecoCliente.setText(clientesObs.get(i).getEndereco());
                this.telefoneCliente.setText(clientesObs.get(i).getTelefone());

                JOptionPane.showMessageDialog(null,
                        "Altere o que desejar.");
            } else {
                try {
                    Cliente novoCliente = new Cliente(this.nomeCliente.getText(), this.cpfCliente.getText(),
                            this.cnhCliente.getText(), this.enderecoCliente.getText(),
                            this.telefoneCliente.getText());

                    this.clientesObs.add(i, novoCliente);
                    this.clientesObs.remove(i + 1);

                    this.nomeCliente.clear();
                    this.cpfCliente.clear();
                    this.cnhCliente.clear();
                    this.enderecoCliente.clear();
                    this.telefoneCliente.clear();

                    nomeCliente.requestFocus();

                    JOptionPane.showMessageDialog(null, "Cliente "
                            + novoCliente.getNome() + " alterado com sucesso.");

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            "Entradas inválidas, corrija e envie novamente.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Selecione um cliente para alterar.");
        }
    }

    @FXML
    void deletaObj(ActionEvent evet) {
        int i = this.tabelaClientes.getSelectionModel().getSelectedIndex();
        if (i >= 0) {
            this.clientesObs.remove(i);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Selecione um cliente para remover.");
        }
    }

    @FXML
    void voltarMenuInicial(ActionEvent event) throws Exception {

        root = FXMLLoader.load(getClass().getResource("MenuInicial.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private ObservableList<Cliente> clientesObs;

    @FXML
    void initialize() {

        listaClientes = MenuInicial.getListaClientes();

        clientesObs = MenuInicial.getObsListaClietnes();

        colunaCPF.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cpf"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));

        tabelaClientes.setItems(clientesObs);
    }
}