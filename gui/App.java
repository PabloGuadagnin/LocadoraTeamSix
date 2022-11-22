package gui;

import java.util.Optional;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("layoutInicio.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(event -> {
                if (sairDaAplicacao())
                    System.exit(0);
                event.consume();
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    public static void main(String[] args) {
        launch(args);
    }
}
