package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.control.JanelaBase;

import java.io.IOException;

public class Navegador {

    public static final String BASE = "/view/base.fxml";
    public static final String MENU_PRINCIPAL = "/view/telaPizzaria.fxml";
    public static final String MENU_CLIENTES = "/view/menuClientes.fxml";

    private static JanelaBase controlador;

    public static void setControlador(JanelaBase controlador) {
        Navegador.controlador = controlador;
    }

    public static void loadJanela(String fxml) {
        try {
            controlador.setJanela((Node) FXMLLoader.load(
                    Navegador.class.getResource(
                            fxml
                    )
                    )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadJanelaSolta(String fxml) throws Exception {
        try {
            Parent root;

            root = FXMLLoader.load(
                    Navegador.class.getResource(
                            fxml
                    )
            );

            Scene scene = new Scene(root, 300, 450);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
