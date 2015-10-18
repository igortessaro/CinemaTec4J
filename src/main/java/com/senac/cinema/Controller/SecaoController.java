package com.senac.cinema.Controller;

import com.senac.cinema.Core.Console;
import com.senac.cinema.Core.ExceptionDefaultMessage;
import com.senac.cinema.Domain.Filme;
import com.senac.cinema.Domain.Sala;
import com.senac.cinema.Domain.Secao;
import com.senac.cinema.Service.FilmeService;
import com.senac.cinema.Service.SalaService;
import com.senac.cinema.Service.SecaoService;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map.Entry;

public class SecaoController extends BaseController {

    private SecaoService service;
    private FilmeService filmeService;
    private SalaService salaService;

    public SecaoController() {
        super.setTituloPagina("Seção");
        this.service = new SecaoService();
        this.filmeService = new FilmeService();
        this.salaService = new SalaService();
    }

    @Override
    public void adicionar() {
        Secao secao = new Secao();

        try {
            secao.setTempoDuracaoMinutos(Console.lerInteger("Informe o tempo de duração em minutos: "));

            String dataString = Console.lerString("Informe a data(ex: 18/10/2015): ");
            String horaString = Console.lerString("Informe a hora de incio(ex: 11:00): ");
            String dataHoraString = String.format("%s %s:00", dataString, horaString);
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            secao.setDataHoraInicio(fmt.parse(dataHoraString));

            System.out.println("");
            System.out.println("Filmes:");
            System.out.println("");
            
            HashMap<Integer, Filme> filmeSelects = this.filmeService.searchAll();

            for (Entry<Integer, Filme> entry : filmeSelects.entrySet()) {
                Integer key = entry.getKey();
                Filme value = entry.getValue();

                if (value != null) {
                    Console.imprimir(key + " - " + value.getNome());
                    System.out.println("");
                }
            }

            System.out.println("");
            int opcaoFilme = Console.lerInteger("Informe o filme desejado: ");
            
            if(!filmeSelects.containsKey(opcaoFilme))
                throw new IllegalArgumentException("Filme não existe...");
            
            secao.setFilmeId(opcaoFilme);
            
            System.out.println("");
            System.out.println("Salas:");
            System.out.println("");
            
            HashMap<Integer, Sala> salaSelects = this.salaService.searchAll();

            for (Entry<Integer, Sala> entry : salaSelects.entrySet()) {
                Integer key = entry.getKey();
                Sala value = entry.getValue();

                if (value != null) {
                    Console.imprimir(key + " - Número " + value.getNumero());
                    System.out.println("");
                }
            }

            System.out.println("");
            int opcaoSala = Console.lerInteger("Informe a sala desejada: ");
            
            if(!salaSelects.containsKey(opcaoSala))
                throw new IllegalArgumentException("Sala não existe...");
            
            secao.setSalaId(opcaoSala);            
            
            service.save(secao);
            System.out.println("Seção inserido com sucesso...");
        } catch (Exception e) {
            ExceptionDefaultMessage.messageError(e.getMessage());
        }
    }
}
