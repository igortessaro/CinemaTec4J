package com.senac.cinema.BaseRepository;

import com.senac.cinema.Domain.Filme;
import com.senac.cinema.Domain.Ingresso;
import com.senac.cinema.Domain.Sala;
import com.senac.cinema.Domain.Secao;
import java.util.HashSet;

public class BancoDados {
    private static HashSet<Filme> filmeList;
    private static HashSet<Ingresso> ingressoList;
    private static HashSet<Sala> salaList;
    private static HashSet<Secao> secaoList;
    
    private BancoDados() {
        this.filmeList = new HashSet<>();
        this.ingressoList = new HashSet<>();
        this.salaList = new HashSet<>();
        this.secaoList = new HashSet<>();
    }
    
    public static BancoDados getInstance() {
        return BancoDadosHolder.INSTANCE;
    }
    
    private static class BancoDadosHolder {
        private static final BancoDados INSTANCE = new BancoDados();
    }

    public static HashSet<Filme> getFilmeList() {
        return filmeList;
    }

    public static HashSet<Ingresso> getIngressoList() {
        return ingressoList;
    }

    public static HashSet<Sala> getSalaList() {
        return salaList;
    }

    public static HashSet<Secao> getSecaoList() {
        return secaoList;
    }
}
