package com.senac.cinema.Domain;

public enum Genero {
    Acao(1), Aventura(2), Comedia(3), Drama(4), Ficcao(5), Romance(6), Suspense(7), Terror(8);
    
    private final int value;
    
    private Genero(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
