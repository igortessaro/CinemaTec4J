package com.senac.cinema.Service;

import com.senac.cinema.BaseRepository.CrudBD;
import com.senac.cinema.BaseRepository.TypeOperation;
import com.senac.cinema.Domain.Filme;
import com.senac.cinema.Repository.FilmeRepository;
import java.util.HashMap;
import java.util.List;

public class FilmeService extends CrudBD<Filme>{
    private final FilmeRepository repository;
    
    public FilmeService() {
        this.repository = new FilmeRepository();
    }
    
    @Override
    public void save(Filme entity) {
        this.validateRules(entity, TypeOperation.Insert);
        this.repository.save(entity);
    }

    @Override
    public void delete(Filme entity) {
        this.validateRules(entity, TypeOperation.Delete);
        this.repository.delete(entity);
    }

    @Override
    public Filme search(Filme entity) {
        return this.repository.search(entity);
    }

    @Override
    public void update(Filme entity) {
        this.validateRules(entity, TypeOperation.Update);
        this.repository.update(entity);
    }

    @Override
    public List<Filme> search(String search) {
        return this.repository.search(search);
    }
    
    public HashMap<Integer, Filme> searchAll(){
        HashMap<Integer, Filme> hm = new HashMap<>();
        
        List<Filme> filmeList = this.repository.searchAll();
        
        for (Filme filme : filmeList) {
            if(filme == null) continue;
            
            hm.put(filme.getId(), filme);
        }
        
        return hm;
    }
    
    public List<Filme> obterTodos(){        
        return this.repository.searchAll();
    }
    
    private void validateRules(Filme entity, TypeOperation operation){
        switch(operation){
            case Delete:
                this.validateDelete(entity);
                break;
            case Insert:
                this.validateInsert(entity);
                break;
            case Update:
                this.validateUpdate(entity);
                break;
        }
    }
    
    private void validateInsert(Filme entity){
        this.validateDefault(entity);
        
        if(entity.getId() > 0)
            throw new IllegalArgumentException("Filme não deve possuir ID.");
        
        List<Filme> filmeList = this.repository.search(entity.getNome());
        
        if(filmeList != null && filmeList.size() > 0)
            throw new IllegalArgumentException("Filme já existente."); 
    }
    
    private void validateDelete(Filme entity){
        if(entity.getId() == 0)
            throw new IllegalArgumentException("ID do filme não informado.");
    }
    
    private void validateUpdate(Filme entity){
        this.validateDefault(entity);
    }
    
    private void validateDefault(Filme entity){        
        if(entity == null)
            throw new IllegalArgumentException("Filme não informado.");
        
        if(entity.getGenero() == null)
            throw new IllegalArgumentException("Genero não informado.");
        
        if(entity.getNome() == null || entity.getNome().isEmpty())
            throw new IllegalArgumentException("Nome não informado.");
        
        if(entity.getSinopse() == null || entity.getSinopse().isEmpty())
            throw new IllegalArgumentException("Sinopse não informado.");
    }
}
