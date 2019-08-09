package sample.control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import sample.Navegador;
import sample.model.Pizza;
import sample.model.Pizzaria;

import java.io.FileNotFoundException;
import java.io.IOException;

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

    public void initialize() throws IOException, ClassNotFoundException {
        Pizzaria.getInstance().CarregarSabores();
        ltvListaSabores.getItems().addAll(Pizzaria.getInstance().listaSabores());
    }

    @FXML
    private void cadastrarPizza() throws Exception{
        String sabor;
        double valor;

        if(!tfValor.getText().isEmpty()){
            valor = Double.valueOf(tfValor.getText());
        }
        else{
            valor = 0.0;
        }
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

    @FXML
    private void verClientes(){
        try{
            Navegador.loadJanelaSolta(Navegador.MENU_CLIENTES);

        }catch(Exception e){
            System.out.println("a");
        }
    }
}
