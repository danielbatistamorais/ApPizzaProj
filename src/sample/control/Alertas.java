package sample.control;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Alertas {

    protected void pedidoFechado(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Pedido Fechado!");

        Optional<ButtonType> resultado = alert.showAndWait();

        if(resultado.isPresent() && resultado.get() == ButtonType.OK){

        }
    }

    protected void pedidoNaoAberto(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Nenhum Pedido Aberto!");

        Optional<ButtonType> resultado = alert.showAndWait();

        if(resultado.isPresent() && resultado.get() == ButtonType.OK){

        }
    }

    protected void pedidoJaAberto(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Já existe um pedido aberto!");

        Optional<ButtonType> resultado = alert.showAndWait();

        if(resultado.isPresent() && resultado.get() == ButtonType.OK){

        }
    }



}
