package com.senac.cinema.Controller;

import com.senac.cinema.Core.Console;
import com.senac.cinema.Core.ExceptionDefaultMessage;
import com.senac.cinema.Domain.Filme;
import com.senac.cinema.Domain.Genero;
import com.senac.cinema.Service.FilmeService;

public class FilmeController extends BaseController {

    private FilmeService service;

    public FilmeController() {
        super.setTituloPagina("Filme");
        this.service = new FilmeService();
    }

    @Override
    public void adicionar() {
        Filme filme = new Filme();

        filme.setNome(Console.lerString("Informe o nome: "));

        filme.setGenero(Genero.fromInteger(Console.lerEnum("Informe o gênero: ", Genero.class)));

        filme.setSinopse(Console.lerString("Informe a sinopse: "));

        try {
            service.save(filme);
            System.out.println("Filme inserido com sucesso...");
        } catch (Exception e) {
            ExceptionDefaultMessage.messageError(e.getMessage());
        }
    }
}
