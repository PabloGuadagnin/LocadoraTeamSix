package gui;

import java.io.IOException;

import cadastramentos.*;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 * Classe responsável por controlar a interface gráfica MenuInicial ( Controller )
 * 
 */
public class MenuInicial{

    private Stage stage;
    private Scene scene;
    private Parent root;

    CadClientes listaClientes = new CadClientes();
    CadVeiculos listaVeiculos = new CadVeiculos();
    CadLocacoes listaLocacoes = new CadLocacoes();

    private MenuClientes menuClientes;
    private MenuVeiculos menuVeiculos;
    private MenuLocacoes menuLocacoes;

    public MenuInicial(){
        menuClientes = new MenuClientes(listaClientes);
        menuVeiculos = new MenuVeiculos(listaVeiculos);
        menuLocacoes = new MenuLocacoes(listaLocacoes, listaVeiculos, listaClientes);
    }

    @FXML
    void cadastrarClientes(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("layoutMC.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void cadastrarLocacao(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("layoutML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void cadastrarVeiculos(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("layoutMV.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}