package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

public class Pedido {

    private ObservableList<Pizza> pizzas;
    private double valorTotal;

    public Pedido() {
        pizzas = FXCollections.observableArrayList();
    }

    public void addPizza(Pizza p){
        pizzas.add(p);
        valorTotal = valorTotal + p.getValor();
    }

    public void removePizza(Pizza p){
        pizzas.remove(p);
        valorTotal = valorTotal - p.getValor();
    }


    public double getValorTotal() {
        return valorTotal;
    }

    public ObservableList listaPizzas(){
        return pizzas;
    }
}
