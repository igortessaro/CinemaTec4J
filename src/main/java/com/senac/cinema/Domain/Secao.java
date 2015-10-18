package com.senac.cinema.Domain;

import java.util.Date;

public class Secao {
    private int id;
    
    private int salaId;
    
    private int filmeId;
    
    private Date dataHoraInicio;
    
    private int tempoDuracaoMinutos;

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
}
