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
    protected void erroAoCadastrar(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Insira um valor e um sabor para a pizza!");

        Optional<ButtonType> resultado = alert.showAndWait();

        if(resultado.isPresent() && resultado.get() == ButtonType.OK){

        }
    }

    protected void cadastradoComSucesso(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Pizza cadastrada com sucesso!");

        Optional<ButtonType> resultado = alert.showAndWait();

        if(resultado.isPresent() && resultado.get() == ButtonType.OK){

        }
    }

}
