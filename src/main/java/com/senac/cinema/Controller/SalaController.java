package com.senac.cinema.Controller;

import com.senac.cinema.Core.Console;
import com.senac.cinema.Core.ExceptionDefaultMessage;
import com.senac.cinema.Domain.Sala;
import com.senac.cinema.Service.SalaService;
import java.util.List;

public class SalaController extends BaseController {

    private SalaService service;

    public SalaController() {
        super.setTituloPagina("Sala");
        this.service = new SalaService();
    }

    @Override
    public void adicionar() {
        Sala sala = new Sala();

        sala.setNumero(Console.lerInteger("Informe o número: "));

        sala.setQuantidadeAssentos(Console.lerInteger("Informa a quantidade de assentos: "));

        try {
            this.service.save(sala);
            System.out.println("Sala inserido com sucesso...");
        } catch (Exception e) {
            ExceptionDefaultMessage.messageError(e.getMessage());
        }
    }

    public void adicionar(Sala sala) {
        this.service.save(sala);
    }
    
    public void atualizar(Sala sala){
        this.service.update(sala);
    }

    public List<Sala> obterTodos() {
        return this.service.obterTodos();
    }

    public List<Sala> obterPorNumero(int numero) {
        return this.service.obterPorNumero(numero);
    }

    public void excluir(int id) {
        Sala sala = new Sala();
        sala.setId(id);
        this.service.delete(sala);
    }
}
