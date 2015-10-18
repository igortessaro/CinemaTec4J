package com.senac.cinema.Domain;

import java.util.Date;

public class Secao {
    private int id;
    
    private int salaId;
    
    private int filmeId;
    
    private Date dataHoraInicio;
    
    private int tempoDuracaoMinutos;
    
    private Filme filme;
    
    private Sala sala;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalaId() {
        return salaId;
    }

    public void setSalaId(int salaId) {
        this.salaId = salaId;
    }

    public int getFilmeId() {
        return filmeId;
    }

    public void setFilmeId(int filmeId) {
        this.filmeId = filmeId;
    }

    public Date getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(Date dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public int getTempoDuracaoMinutos() {
        return tempoDuracaoMinutos;
    }

    public void setTempoDuracaoMinutos(int tempoDuracaoMinutos) {
        this.tempoDuracaoMinutos = tempoDuracaoMinutos;
    }    

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
    @Override
    public String toString(){
        String result = "";
        
        result = String.format("Seção: ID - %s", this.id);
        result = String.format("%s | Começa em %s", result, this.dataHoraInicio);
        result = String.format("%s | Tem %s minutos de duração", result, this.tempoDuracaoMinutos);
        
        if(this.filme != null)
            result = String.format("%s | Filme - %s ", result, this.filme.getNome());
        
        if(this.sala != null)
            result = String.format("%s | Sala - %s ", result, this.sala.getNumero());
        
        return result;
    }
}
