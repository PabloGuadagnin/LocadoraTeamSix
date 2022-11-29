package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import cadastramentos.CadClientes;
import construtores.*;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Classe responsável por controlar a interface gráfica de Clientes ( Controller
 * )
 */
public class MenuClientes implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private CadClientes listaClientes = new CadClientes();

    public MenuClientes() {
    }

    public MenuClientes(CadClientes listaClientes) {
        this.listaClientes = listaClientes;
    }

    Cliente cliente = new Cliente(null, null, null, null, null);

    // Cadastro de Clientes
    @FXML
    private TextField cnhCliente;

    @FXML
    private TextField cpfCliente;

    @FXML
    private TextField enderecoCliente;

    @FXML
    private TextField nomeCliente;

    @FXML
    private TextField telefoneCliente;

    @FXML
    private TableView<CadClientes> tabelaClientes;

    @FXML
    private TableColumn<CadClientes, String> colunaCPF;

    @FXML
    private TableColumn<CadClientes, String> colunaNome;

    @FXML
    void confirmarCadastro(ActionEvent event) {
        try {
            cliente.setNome(nomeCliente.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorre");
        }
        
        cliente.setCpf(cpfCliente.getText());
        cliente.setCnh(cnhCliente.getText());
        cliente.setEndereco(enderecoCliente.getText());
        cliente.setTelefone(telefoneCliente.getText());

        listaClientes.add(cliente);

        JOptionPane.showMessageDialog(null, "Cliente "
                + cliente.getNome() + " cadastrado com sucesso.");

        nomeCliente.setText("");
        cpfCliente.setText("");
        cnhCliente.setText("");
        enderecoCliente.setText("");
        telefoneCliente.setText("");

        nomeCliente.requestFocus();
    }

    @FXML
    void voltarMenuInicial(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("layoutInicio.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}