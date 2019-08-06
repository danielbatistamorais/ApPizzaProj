package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.control.Alertas;

public class Pizzaria extends Alertas {

    private ObservableList<Pizza> sabores;
    private Pedido pedido;

    private static Pizzaria instance = new Pizzaria();

    private Pizzaria(){
        sabores = FXCollections.observableArrayList();
    }

    public static Pizzaria getInstance() {
        return instance;
    }

    public void cadastraPizza(String sabor, Double valor){
        Pizza p = new Pizza(sabor, valor);
        sabores.add(p);
        System.out.println(sabores);
    }

    public void abrirPedido(){
        if(pedido == null){
            pedido = new Pedido();
        }
        else{
            pedidoJaAberto();
        }
    }

    public void removerPizza(Pizza p){
        if(pedido != null){
            pedido.removePizza(p);
        }
    }

    public void incluirPizza(Pizza p){
        if(pedido != null){
            pedido.addPizza(p);
        }
        else{
            pedidoNaoAberto();
        }
    }

    public double fecharPedido(){
        double valor;
        if(pedido != null){
            valor = pedido.getValorTotal();
            pedido = null;
            return valor;
        }
        else{
            pedidoNaoAberto();
        }
        return 0.0;
    }

    public ObservableList listaSabores(){
        return sabores;
    }

    public double valorPedido(){
        if(pedido != null){
            return pedido.getValorTotal();
        }

        return 0.0;
    }

    public ObservableList getListaPedido(){
        if(pedido != null){
            return pedido.listaPizzas();
        }
        else{
            return FXCollections.emptyObservableList();
        }
    }

}
