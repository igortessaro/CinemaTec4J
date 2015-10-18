package com.senac.cinema.Controller;

import com.senac.cinema.Core.Console;
import com.senac.cinema.Core.ExceptionDefaultMessage;
import com.senac.cinema.Domain.Sala;
import com.senac.cinema.Service.SalaService;

public class SalaController extends BaseController{
    
    private SalaService service;
    
    public SalaController(){
        super.setTituloPagina("Sala");
        this.service = new SalaService();                
    }
    
    @Override
    public void adicionar() {
        Sala sala = new Sala();

        sala.setNumero(Console.lerInteger("Informe o número: "));
        
        sala.setQuantidadeAssentos(Console.lerInteger("Informa a quantidade de assentos: "));

        try {
            service.save(sala);
            System.out.println("Sala inserido com sucesso...");
        } catch (Exception e) {
            ExceptionDefaultMessage.messageError(e.getMessage());
        }
    }    
}
