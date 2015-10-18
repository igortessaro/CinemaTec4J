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

    public static Genero fromInteger(int value) {
        switch (value) {
            case 1:
                return Acao;
            case 2:
                return Aventura;
            case 3:
                return Comedia;
            case 4:
                return Drama;
            case 5:
                return Ficcao;
            case 6:
                return Romance;
            case 7:
                return Suspense;
            case 8:
                return Terror;
            default:
                throw new IllegalArgumentException("Gênero não encontrado!");
        }
    }
}
