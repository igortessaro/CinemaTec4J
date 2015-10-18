package com.senac.cinema.Domain;

public class Ingresso {
    private int id;
    
    private int secaoId;
    
    private float valor;

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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
