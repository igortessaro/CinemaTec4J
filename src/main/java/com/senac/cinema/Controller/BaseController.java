package com.senac.cinema.Controller;

import com.senac.cinema.Core.Console;

public abstract class BaseController implements IBaseController{
    private String tituloPagina;

    public String getTituloPagina() {
        return tituloPagina;
    }

    public void setTituloPagina(String tituloPagina) {
        this.tituloPagina = tituloPagina;
    }
    
    @Override
    public void index() {
        Console.imprimir("");
        Console.imprimirTituloCadastro(this.tituloPagina);
        
    }
    
}
