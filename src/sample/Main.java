package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.control.JanelaBase;

import java.io.IOException;

public class Main extends Application {

    public void start(Stage stage) throws Exception{
        Pane root = loadMainPane();

        stage.setScene(new Scene(root, 750, 450));

        stage.setTitle("Pizzaria");
        stage.show();
    }

    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(
                getClass().getResourceAsStream(
                        Navegador.BASE
                )
        );

        JanelaBase controller = loader.getController();

        Navegador.setControlador(controller);
        Navegador.loadJanela(Navegador.MENU_PRINCIPAL);

        return mainPane;
    }
}
