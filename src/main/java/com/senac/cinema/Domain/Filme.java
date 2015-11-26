package com.senac.cinema.Domain;

import com.jdf.swing.helper.jtable.JTableColumnMetadata;

public class Filme {
    @JTableColumnMetadata(name = "Código")
    private int id;
    
    @JTableColumnMetadata(name = "Nome")
    private String nome;
    
    @JTableColumnMetadata(name = "Genero")
    private Genero genero;
    
    @JTableColumnMetadata(name = "Sinopse")
    private String sinopse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
}
