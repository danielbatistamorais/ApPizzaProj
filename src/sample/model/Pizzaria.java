package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.control.Alertas;

import java.io.*;
import java.util.ArrayList;

public class Pizzaria extends Alertas {


    private static String FILE="sabores.bin";
    private static String FILE_CLIENTES="clientes.bin";
    private ObservableList<Pizza> sabores;
    private ObservableList<Cliente> clientes;
    private Pedido pedido;

    private static Pizzaria instance = new Pizzaria();

    private Pizzaria(){
        sabores = FXCollections.observableArrayList();
        clientes = FXCollections.observableArrayList();
    }

    public static Pizzaria getInstance() {
        return instance;
    }

    public void cadastraPizza(String sabor, Double valor) throws Exception{
        if(sabor != null && valor != 0.0){
            Pizza p = new Pizza(sabor, valor);
            sabores.add(p);
            SalvarSabores();
            CarregarSabores();
            cadastradoComSucesso();
        }
        else{
            erroAoCadastrar();
        }
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
            pedidoFechado();
            return valor;
        }
        else{
            pedidoNaoAberto();
        }
        return 0.0;
    }

    public ObservableList listaSabores(){
        return FXCollections.unmodifiableObservableList(sabores);
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

    public ObservableList listaClientes(){
        return FXCollections.unmodifiableObservableList(clientes);
    }

    public void CarregarSabores(){
        sabores.clear();

        try{
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(
                            new File(FILE)
                    )
            );

            ArrayList<Pizza> temp = (ArrayList)ois.readObject();

            sabores.addAll(temp);

            ois.close();
        }catch(Exception e){
            System.out.println("erro ao carregar");
        }
    }

    public void SalvarSabores(){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(
                            new File(FILE))
            );

            ArrayList<Pizza> temp = new ArrayList<>();
            temp.addAll(sabores);

            oos.writeObject(temp);

            oos.close();
        }catch(Exception e){
            System.out.println("erro ao salvar");
        }
    }

    public void SalvarClientes(){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(
                            new File(FILE_CLIENTES))
            );

            ArrayList<Cliente> temp = new ArrayList<>();
            temp.addAll(clientes);

            oos.writeObject(temp);

            oos.close();
        }catch(Exception e){
            System.out.println("Erro ao salvar clientes");
        }
    }

    public void cadastraCliente(String nome, String numero, String endereco){

        if(!nome.isEmpty() && !numero.isEmpty() && !endereco.isEmpty()){
            Cliente c = new Cliente(nome, numero, endereco);
            clientes.add(c);
            clienteCadastradoComSucesso();
        }
        else{
            erroAoCadastrarCliente();
        }
    }

    public void removeClientes(Cliente c){

        if(c != null){
            if(confirmaRemocao(c.getNome())){
                clientes.remove(c);
            }
        }
    }
}
