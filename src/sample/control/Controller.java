package sample.control;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import sample.model.Pizza;
import sample.model.Pizzaria;

public class Controller {

    @FXML
    private TextField tfSabor;

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
    }

    @FXML
    private void fecharPedido() throws Exception {
        Pizzaria.getInstance().fecharPedido();
    }

    @FXML
    private void addPizza() throws Exception{
        if(ltvListaSabores.getSelectionModel().getSelectedItem() != null){
            Pizzaria.getInstance().incluirPizza(ltvListaSabores.getSelectionModel().getSelectedItem());
        }
        ltvListaSabores.getItems().addAll(Pizzaria.getInstance().getSabores());
        ltvListaPedido.getItems().addAll(Pizzaria.getInstance().getListaPedido());
    }

    @FXML
    private void removerPizza(){
        if(ltvListaPedido.getSelectionModel().getSelectedItem()!=null){
            Pizzaria.getInstance().removerPizza(ltvListaPedido.getSelectionModel().getSelectedItem());
        }
        ltvListaSabores.getItems().addAll(Pizzaria.getInstance().getSabores());
        ltvListaPedido.getItems().addAll(Pizzaria.getInstance().getListaPedido());
    }



}
