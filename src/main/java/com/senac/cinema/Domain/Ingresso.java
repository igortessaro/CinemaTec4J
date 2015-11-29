package com.senac.cinema.Domain;

import com.jdf.swing.helper.jtable.JTableColumnMetadata;

public class Ingresso {
    @JTableColumnMetadata(name = "Código")
    private int id;
    
    @JTableColumnMetadata(name = "Seção ID")
    private int secaoId;
    
    @JTableColumnMetadata(name = "Valor")
    private double valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSecaoId() {
        return secaoId;
    }

    public void setSecaoId(int secaoId) {
        this.secaoId = secaoId;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
