package gui2;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import construtores.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MenuClientes {

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
    private TextField telefoneCliente;

    @FXML
    void confirmarCadastro(ActionEvent event) {

        if (this.nomeCliente.getText() != null && this.cpfCliente.getText() != null &&
                this.cnhCliente.getText() != null && this.enderecoCliente.getText() != null &&
                this.telefoneCliente.getText() != null) {
            try {
                Cliente novoCliente = new Cliente(this.nomeCliente.getText(), this.cpfCliente.getText(),
                        this.cnhCliente.getText(), this.enderecoCliente.getText(), this.telefoneCliente.getText());

                this.clientesObs.add(novoCliente);

                this.nomeCliente.clear();
                this.cpfCliente.clear();
                this.cnhCliente.clear();
                this.enderecoCliente.clear();
                this.telefoneCliente.clear();

                nomeCliente.requestFocus();

                JOptionPane.showMessageDialog(null, "Cliente "
                        + novoCliente.getNome() + " cadastrado com sucesso.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Entradas inválidas, corrija e envie novamente.");
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Todos os campos são obrigatórios.");
        }
    }

    @FXML
    void voltarMenuInicial(ActionEvent event) {

    }

    private ObservableList<Cliente> clientesObs;

    @FXML
    void initialize() {

        this.clientesObs = FXCollections.observableArrayList();

        TableColumn cpfCol = new TableColumn("CPF");
        TableColumn nomeCol = new TableColumn("Nome");
        TableColumn editCol = new TableColumn("Editar");
        TableColumn excCol = new TableColumn("Excluir");

        cpfCol.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cpf"));
        nomeCol.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));

        this.tabelaClientes.getColumns().addAll(cpfCol, nomeCol, editCol, excCol);
        this.tabelaClientes.setItems(clientesObs);

        assert cnhCliente != null : "fx:id=\"cnhCliente\" was not injected: check your FXML file 'MenuClientes.fxml'.";
        assert cpfCliente != null : "fx:id=\"cpfCliente\" was not injected: check your FXML file 'MenuClientes.fxml'.";
        assert enderecoCliente != null
                : "fx:id=\"enderecoCliente\" was not injected: check your FXML file 'MenuClientes.fxml'.";
        assert nomeCliente != null
                : "fx:id=\"nomeCliente\" was not injected: check your FXML file 'MenuClientes.fxml'.";
        assert tabelaClientes != null
                : "fx:id=\"tabelaClientes\" was not injected: check your FXML file 'MenuClientes.fxml'.";
        assert telefoneCliente != null
                : "fx:id=\"telefoneCliente\" was not injected: check your FXML file 'MenuClientes.fxml'.";

    }

}