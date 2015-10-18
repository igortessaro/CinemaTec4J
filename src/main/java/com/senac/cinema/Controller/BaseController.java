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
        Console.pularLinha();
        Console.imprimirTituloCadastro(this.tituloPagina);
        Console.pularLinha();
        Console.pularLinha();
        this.adicionar();
    }
    
    public void adicionar(){
        
    }    
}
