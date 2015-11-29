package com.senac.cinema.Domain;

import com.jdf.swing.helper.jtable.JTableColumnMetadata;

public class Sala {
    @JTableColumnMetadata(name = "Código")
    private int id;
    
    @JTableColumnMetadata(name = "Número")
    private int numero;
    
    @JTableColumnMetadata(name = "Quantidade de Assentos")
    private int quantidadeAssentos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getQuantidadeAssentos() {
        return quantidadeAssentos;
    }

    public void setQuantidadeAssentos(int quantidadeAssentos) {
        this.quantidadeAssentos = quantidadeAssentos;
    }    
    
    @Override
    public String toString(){
        return String.format("Sala - [ID: %s - Número: %s]", this.id, this.numero);
    }
}
