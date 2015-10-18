package com.senac.cinema.Service;

import com.senac.cinema.BaseRepository.CrudBD;
import com.senac.cinema.Domain.Filme;
import com.senac.cinema.Repository.FilmeRepository;
import java.util.List;

public class FilmeService extends CrudBD<Filme>{
    private final FilmeRepository repository;
    
    public FilmeService() {
        this.repository = new FilmeRepository();
    }
    
    @Override
    public void save(Filme entity) {
        this.repository.save(entity);
    }

    @Override
    public void delete(Filme entity) {
        this.repository.delete(entity);
    }

    @Override
    public Filme search(Filme entity) {
        return this.repository.search(entity);
    }

    @Override
    public void update(Filme entity) {
        this.repository.update(entity);
    }

    @Override
    public List<Filme> search(String search) {
        return this.repository.search(search);
    }    
}
