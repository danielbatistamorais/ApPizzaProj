package sample.model;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String nome;
    private String numero;
    private String endereço;

    public Cliente(String nome, String numero, String endereço) {
        this.nome = nome;
        this.numero = numero;
        this.endereço = endereço;
    }

    public String getNome(){
        return nome;
    }

    @Override
    public String toString() {
        return "~Cliente~" +
                "\nNome: "+nome+
                "\nNumero: "+ numero+
                "\nEndereço "+ endereço;
    }
}
