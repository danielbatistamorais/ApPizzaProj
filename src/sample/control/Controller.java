package sample.control;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import sample.model.Pizza;
import sample.model.Pizzaria;

public class Controller {

    @FXML
    private TextField tfSabor;

    @FXML
    private Label lbValorTotal;

    @FXML
    private TextField tfValor;

    @FXML
    private ListView<Pizza> ltvListaSabores;

    @FXML
    private ListView<Pizza> ltvListaPedido;

    @FXML
    private void cadastrarPizza(){
        String sabor;
        double valor;

        valor = Double.valueOf(tfValor.getText());
        sabor = tfSabor.getText();

        Pizzaria.getInstance().cadastraPizza(sabor, valor);
        ltvListaSabores.getItems().clear();
        ltvListaSabores.getItems().addAll(Pizzaria.getInstance().listaSabores());
    }

    @FXML
    private void fecharPedido() throws Exception {
        Pizzaria.getInstance().fecharPedido();
        lbValorTotal.setText("Valor total:" +Pizzaria.getInstance().valorPedido()+"R$");
        ltvListaPedido.getItems().clear();
        ltvListaPedido.getItems().addAll(Pizzaria.getInstance().getListaPedido());
    }

    @FXML
    private void addPizza() throws Exception{
        if(ltvListaSabores.getSelectionModel().getSelectedItem() != null){
            Pizzaria.getInstance().incluirPizza(ltvListaSabores.getSelectionModel().getSelectedItem());
        }
        lbValorTotal.setText("Valor total:" +Pizzaria.getInstance().valorPedido()+"R$");
        ltvListaPedido.getItems().clear();
        ltvListaPedido.getItems().addAll(Pizzaria.getInstance().getListaPedido());
    }

    @FXML
    private void removerPizza(){
        if(ltvListaPedido.getSelectionModel().getSelectedItem()!=null){
            Pizzaria.getInstance().removerPizza(ltvListaPedido.getSelectionModel().getSelectedItem());
        }

        lbValorTotal.setText("Valor total:" +Pizzaria.getInstance().valorPedido()+"R$");
        ltvListaPedido.getItems().clear();
        ltvListaPedido.getItems().addAll(Pizzaria.getInstance().getListaPedido());
    }

    @FXML
    private void abrirPedido(){
        Pizzaria.getInstance().abrirPedido();
    }



}
