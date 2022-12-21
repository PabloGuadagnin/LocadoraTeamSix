package gui;

import java.net.URL;
import java.util.Optional;

import cadastramentos.CadClientes;
import cadastramentos.CadLocacoes;
import cadastramentos.CadVeiculos;
import construtores.Cliente;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * Classe principal do projeto, responsável pela inicialização do programa
 *
 * @author @pabloguadagnin
 * 
 */
public class Main extends Application {

    /**
     * 
     * Método responsável por inicializar o programa JavaFX
     * 
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        URL xmlURL = getClass().getResource("MenuInicial.fxml");
        loader.setLocation(xmlURL);

        Parent parent = loader.load();

        Scene scene = new Scene(parent);

        CadClientes listaClientes = new CadClientes();
        CadVeiculos listaVeiculos = new CadVeiculos();
        CadLocacoes listaLocacoes = new CadLocacoes();

        ObservableList<Cliente> clientesObs = FXCollections.observableArrayList();

        MenuInicial controller = loader.getController();
        controller.setListaClientes(listaClientes);
        controller.setListaVeiculos(listaVeiculos);
        controller.setListaLocacoes(listaLocacoes);

        controller.setObsListaClietnes(clientesObs);

        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);

        primaryStage.setOnCloseRequest(event -> {
            if (sairDaAplicacao())
                System.exit(0);
            event.consume();
        });
    }

    /**
     * Método responsável por tratar o fechamento do programa, exibindo uma popup de
     * confirmação ao clicar em fechar
     * 
     * @return true or false
     */
    public Boolean sairDaAplicacao() {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Alerta");
        alerta.setHeaderText("Tem Certeza que Deseja Sair?");
        ButtonType botaoNao = ButtonType.NO;
        ButtonType botaoSim = ButtonType.YES;
        alerta.getButtonTypes().setAll(botaoSim, botaoNao);
        Optional<ButtonType> resultado = alerta.showAndWait();

        return resultado.get() == botaoSim ? true : false;
    }

    /**
     * Responsável pela execução da classe
     * 
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
