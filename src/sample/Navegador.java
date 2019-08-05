package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import sample.control.JanelaBase;

import java.io.IOException;

public class Navegador {

    public static final String BASE = "/view/base.fxml";
    public static final String MENU_PRINCIPAL = "/view/telaPizzaria.fxml";

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
}
