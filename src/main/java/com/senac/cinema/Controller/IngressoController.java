package com.senac.cinema.Controller;

import com.senac.cinema.Core.Console;
import com.senac.cinema.Core.ExceptionDefaultMessage;
import com.senac.cinema.Domain.Ingresso;
import com.senac.cinema.Domain.Secao;
import com.senac.cinema.Service.IngressoService;
import com.senac.cinema.Service.SecaoService;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class IngressoController extends BaseController{
    private IngressoService service;
    private SecaoService secaoService;
    
    public IngressoController(){
        super.setTituloPagina("Ingresso");
        this.service = new IngressoService();  
        this.secaoService = new SecaoService();
    }
    
    @Override
    public void adicionar() {
        Ingresso ingresso = new Ingresso();

        System.out.println("");
            System.out.println("Seções:");
            System.out.println("");
            
            HashMap<Integer, Secao> secaoSelects = this.secaoService.searchAll();

            for (Entry<Integer, Secao> entry : secaoSelects.entrySet()) {
                Integer key = entry.getKey();
                Secao value = entry.getValue();

                if (value != null) {
                    Console.imprimir(key + " - " + value.toString());
                    System.out.println("");
                }
            }

            System.out.println("");
            int opcaoSecao = Console.lerInteger("Informe a seção desejada: ");
            
            if(!secaoSelects.containsKey(opcaoSecao))
                throw new IllegalArgumentException("Seção não existe...");
            
            ingresso.setSecaoId(opcaoSecao);
            
            ingresso.setValor(Console.lerDouble("Informe o valor: "));
        
        try {
            service.save(ingresso);
            System.out.println("Ingresso inserido com sucesso...");
        } catch (Exception e) {
            ExceptionDefaultMessage.messageError(e.getMessage());
        }
    }    

    public List<Ingresso> obterTodos() {
        return this.service.searchAll();
    }

    public void salvar(Ingresso ingresso) {
        service.save(ingresso);
    }
}
